import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
/*
 * This class serves the client
 */
public class ServerService extends Server implements Runnable{
    private Socket client=null;
    private String clientBeingServed=null;
    private DataOutputStream dout=null;
    private DataInputStream din=null;
    /*
     * This is construcor that takes client sockte that already has been connected to server and client name.
     * It initializes and input and output streams for serving the respective client
     */
    public ServerService(Socket client,String name) throws IOException {
        this.client=client;
        this.clientBeingServed=name;
        dout=new DataOutputStream(client.getOutputStream());
        din=new DataInputStream(client.getInputStream());
    }
    /*
     * takes out actual message sent by client from its http format
     */
    public String getMessage(String str){
        //System.out.println("returning\n"+str.substring(str.indexOf("message:")+8, str.length()));
        return str.substring(str.indexOf("message:")+8, str.length());
    }
    /*
     * This method converts a message string into HTTP formatted string
     */
    public String getHttpMessage(String msg){
        String str="POST Http/1.1 \n" + "Host: www.uta.com \n" + "User-Agent: Mozilla/5.0 \n"
                + "Content=type: application/x-www-form-urlencoded \n" + "Content-Length: " + msg.length() + " \n"
                + "Date:" + new Date() + " \n" + "message:" + msg;
        return str;
    }
    /*
     * This method execute when thread for this class is executed from Server.java file after connection is accepted
     */
    @Override
    public void run() {
        int waitTime=0;
        try{
            while(client.isConnected()){
                    String msg=din.readUTF();
                    ServerWindow.write(msg);
                    waitTime=Integer.parseInt(getMessage(msg));
                    System.out.println("Equeing:"+clientBeingServed);
                    Server.enqueue(Thread.currentThread(), waitTime);
                    System.out.println("before going to sleep");
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait();
                    }
                    System.out.println("after sleeping");
                    ServerWindow.write("Served client:"+clientBeingServed);
                    dout.writeUTF(getHttpMessage("Server waited "+waitTime+" seconds for "+clientBeingServed));
                    dout.flush();
            }
            client.close();
        }catch(Exception e){
            System.err.println("ServerService:error serving client"+clientBeingServed+e.getMessage());
        }
    }
}