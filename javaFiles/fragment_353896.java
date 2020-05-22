public class ServerMain  {

static ArrayList <Socket> sSocketList = new ArrayList<Socket>();
 static ArrayList <ServerThread> sObjectList = new ArrayList<ServerThread>();
static int oh = 0;
public static void main(String[] args) throws IOException  {

    int portNumber =9000;
    boolean listening = true;
    UpdaterThread update =new UpdaterThread();
    update.start();

    try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 

        while (listening) {

            Socket s=  serverSocket.accept();
            ServerThread st= new ServerThread(s);
            sSocketList.add(s);
            sObjectList.add(st);
            st.start();

        }
    } catch (IOException e) {
        System.err.println("Could not listen on port " + portNumber);
        System.exit(-1);
    }
}
//This might work now
public static void updatethings() {
    for (ServerThread  i : sObjectList){
     i.calculatePos();
    }
}
}