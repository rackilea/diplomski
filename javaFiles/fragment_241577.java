public class ChatServer implements Runnable{

private Socket socket = null;
private ServerSocket server = null;
private Thread       thread = null;

private DataInputStream streamIn  =  null;
private DataOutputStream streamOut = null;


int port;
boolean done ;

public ChatServer(){
    port = 6668;
    try{
        System.out.println("Gewählter Port: " + port + ", bitte warte...");
        server = new ServerSocket(port);
        System.out.println("Server gestartet: " + server);
        start();
    }
    catch(IOException ioe)
    {
        System.out.println(ioe);
    }
}
public void start(){
    if (thread == null){
        thread = new Thread(this);
        thread.start();
    }
}

public void run(){
    while (thread != null){
        try{
            System.out.println("waiting for Client ...");
            socket = server.accept();
            System.out.println("Client accepted: " + socket + " IP: "+ socket.getInetAddress());
            System.out.println("connecting ...");
            open();
            done = false;

            while (!done){
                try{
                    String line = streamIn.readUTF();
                    System.out.println(line);
                    send("Server recieved :"+line);
                    done = line.equals(".bye");
                }
                catch(IOException ioe){
                    done = true;
                    ioe.printStackTrace();
                }
            }
            close();
        }
        catch(IOException ie){
            System.out.println("Acceptance Error: " + ie);
        }
    }
}
public void send(String msg)
{
    try
    {
        if(msg != null) {
            streamOut.writeUTF(msg);
            streamOut.flush();
        }
    }
    catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
}
public void open() throws IOException{
    streamIn  = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    streamOut = new DataOutputStream(socket.getOutputStream());
}
public void close() throws IOException{
    if (socket != null)    socket.close();
    if (streamIn != null)  streamIn.close();
    if (streamOut != null)  streamOut.close();

}
@SuppressWarnings("deprecation")
public void stop(){
    if (thread != null){
        thread.stop();
        thread = null;
    }
}


}