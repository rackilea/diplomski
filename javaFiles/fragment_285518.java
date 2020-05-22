import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public ArrayList<EchoThread> waiting = new ArrayList<EchoThread>();
    public ArrayList<EchoThread> playing = new ArrayList<EchoThread>();
    public ArrayList<Integer> score = new ArrayList<Integer>();

    public static void main(String[] args) {
        try {
            // Instantiate a single server object that you can pass into your connected clients
            Server myServer = new Server();
            ServerSocket server = new ServerSocket(4321);
            while (true) {
                try {
                    Socket socket = server.accept();
                    // Pass myServer into Echo Thread 
                    new EchoThread(myServer, socket).start();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Have to synchronize this since multiple clients could be adding to this list at the same time
    public synchronized void addClient(EchoThread client) {
        waiting.add(client);
    }

    public int getNumClients() {
        return waiting.size();
    }

    public String getClientName(int i) {
        return waiting.get(i).getCName();
    }

    public void play() {
        int scr = 0;
        for (int i = 0; i < 4; i++) {
            EchoThread clientBeingMovedToPlaying = waiting.get(0);
            playing.add(clientBeingMovedToPlaying);
            score.add(scr);
            waiting.remove(0);

            // This will be a new method in your EchoThread class
            clientBeingMovedToPlaying.SendServerPlayingMessage();
        }
    }

    public boolean checkIfPlaying(String name) {
        boolean isPlaying = false;
        for(EchoThread client : playing) {
            if (client.getName().contentEquals(name)) {
                isPlaying = true;
                break;
            }
        }
        return isPlaying;
    }
}