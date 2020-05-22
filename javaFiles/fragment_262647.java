import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class server {

    ServerSocket ss;
    boolean quite=false;
    ArrayList<MultiServerConnection> OurDomainsConnections=new ArrayList<MultiServerConnection>();
    final AtomicInteger runningCount = new AtomicInteger(0);
    final Integer limit = 3;

    public static void main(String[] args) {
        new server();

    }
    public server() {
        try {
            //TODO use method to take this as an input from user)
            ss=new ServerSocket(3333);//here we are using connection 3333 (change as you want
            while(!quite)
            {

                Socket s=ss.accept();//when a connection to the domain is found we accept it
                if (runningCount.incrementAndGet() < limit){ //increment number of clients and check
                    MultiServerConnection OurConnection = new MultiServerConnection(s,this, runningCount::decrementAndGet);
                    OurConnection.start();//Start Thread
                    OurDomainsConnections.add(OurConnection);//add connection to our Domain Connection
                } else {
                    runningCount.decrementAndGet();
                    s.close();
                    System.out.println("limit exceeded");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//make sure its bloody same with client it took my 15 min to realize that XD
    }
}

interface Callback {
   void call();
}

class MultiServerConnection extends Thread {

    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    server ss;
    boolean quite=false;
    final Callback callbackOnFinish;

    public MultiServerConnection(Socket OurSocket,server OurServer, Callback callbackOnFinish)
    {
        super("MultiServerConnection");//server connection thread
        this.s=OurSocket;
        this.ss=OurServer;
        this.callbackOnFinish = callbackOnFinish;
    }

    public void ServerOutClientIn(String OutText)
    {
        try {
            long ThreadID=this.getId();
            dout.writeUTF(OutText);
            dout.flush();//this is because of a buffer error :<
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ServerOutAllClientIn(String OutText)
    {
        for(int i=0;i<ss.OurDomainsConnections.size();i++)
        {
            MultiServerConnection Connection=ss.OurDomainsConnections.get(i);
            Connection.ServerOutClientIn(OutText);
        }
    }

    public void run()
    {
        try {
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());

            while(!quite)
            {
                while(din.available()==0)
                {
                    try {
                        Thread.sleep(1);//sleep if there is not data coming
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                String ComingText=din.readUTF();
                ServerOutAllClientIn(ComingText);
            }
            din.close();
            dout.close();
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            callbackOnFinish.call();
        }
    }
}