import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class Server{
    private ServerSocket server=null;
    public static Map<Socket,String> clientsConnected=null;
    public static Map<Socket,Runnable> clientsAndThreads=null;
    public static ExecutorService executor=null;
    public static Queue<Thread> requestQueue=null;
    public static Map<Thread,Integer> threadAndRespectiveTime=null;
    /*
     * Contructor
     */
    Server(){
        clientsConnected=new HashMap<Socket,String>();
        clientsAndThreads=new HashMap<Socket,Runnable>();
        threadAndRespectiveTime=new HashMap<>();
        requestQueue=new LinkedList<>();
    }
    /*
     * Accepts connections from clients continually till the server is UP(max 10 clients)
     */
    public void acceptConnection(){
        try{
            executor=Executors.newFixedThreadPool(10);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket client=null;
                    while(server.isBound()){
                        try{
                            client=server.accept();
                            DataInputStream di= new DataInputStream(client.getInputStream());
                            String msg=di.readUTF();
                            clientsConnected.put(client, getMessage(msg));
                            ServerWindow.write(msg);
                            Runnable service= new ServerService(client,getMessage(msg));
                            executor.execute(service);
                        }catch(Exception e){
                            System.err.println("error occurred while accepting connections");
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while(true){
                            Server.dequeue();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }catch(Exception e){
            System.err.println("Server:error while accepting connections"+e.getMessage());
        }
    }
    public static synchronized void enqueue(Thread t,Integer secondsToWait){
        try{
            System.out.println(requestQueue );
            threadAndRespectiveTime.put(t, secondsToWait);
            requestQueue.add(t);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static synchronized void dequeue() throws InterruptedException{
        while(!requestQueue.isEmpty()){
            Thread currentThread=requestQueue.remove();
            Integer timeToWait=threadAndRespectiveTime.get(currentThread);
            System.out.println("time to wait is:"+timeToWait);
            Thread.currentThread().sleep(timeToWait * 1000);
            synchronized (currentThread) {
                currentThread.notify();
            }
        }
    }
    /*
     * This method takes out actual message from http format
     */
    public String getMessage(String str){
        return str.substring(str.indexOf("message:")+8, str.length());
    }
    /*
     * Starts the server listening to port 4000
     */
    public void start_server(){
        try{
            if(server==null || !server.isBound()){
                server = new ServerSocket(4000);
            }
            acceptConnection();
        }catch(Exception e){
            System.err.println("Server:error occurred while server start"+e.getMessage());
        }
    }
    /*
     * Closes client sockets of every connected client, shuts down the thread executor that serves clients
     */
    public void stop_server() throws IOException{
        Iterator it=clientsConnected.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e= (Map.Entry)it.next();
            Socket toBeClosed=(Socket)e.getKey();
            toBeClosed.close();
        }
        executor.shutdownNow();
        server.close();
    }
}