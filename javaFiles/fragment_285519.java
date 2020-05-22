import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoThread extends Thread {
    protected Socket socket;
    protected Server s;
    protected DataInputStream in;
    protected DataOutputStream out;
    protected String line;
    protected String clientName;

    // This way, each EchoThread object knows about the server
    public EchoThread(Server theServer, Socket clientSocket) {
        this.s = theServer;
        this.socket = clientSocket;
    }

    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }

        while (true) {
            try {
                line = in.readLine();
                String[] prot = line.split(":");

                if (prot[0].equals("/login")) {
                    // Original code
                    //s.addClient(prot[1]);

                    // New code
                    clientName = prot[1];
                    s.addClient(this);
                } else if (prot[0].equals("/waiting")) {
                    if (s.checkIfPlaying(prot[1])) {
                        out.writeBytes("Playing" + "\r\n");
                    } else {
                        // You don't want multiple clients firing the play method, so you need to synchronize your server object
                        synchronized (s) {
                            if (s.getNumClients() >= 4) {
                                s.play();
                                out.writeBytes("Playing" + "\r\n");
                            } else {
                                out.writeBytes(s.getNumClients() + "\r\n");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public String getCName() {
        return clientName;
    }

    public void SendServerPlayingMessage() {
        if (out != null) {
            // Send whatever message you want
        }
    }
}