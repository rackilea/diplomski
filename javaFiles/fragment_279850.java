import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RemoteConsole extends JPanel {

    private String text = "Start";

    public static void main(String[] args) throws Exception {

        // your class is called McduPanel
        RemoteConsole remoteConsole = new RemoteConsole();

        // JFrame which contains all components
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.getContentPane().add(remoteConsole);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ServerSocket serverSocket = new ServerSocket(4564);

        // this is a test server which just writes "test"
        // to a port every 1 seconds
        new Thread() {
            public void run() {
                try {
                    Socket socket = new Socket("localhost", 4564);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    while (true) {
                        System.out.println("send");
                        out.println("test");
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();

        // a test client which checks the port every 1.5 seconds
        // and paints the text to a JPanel
        new Thread() {
            public void run() {
                try {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        String message = in.readLine();
                        System.out.println("received: " + message);
                        remoteConsole.appendText(message);
                        remoteConsole.repaint();
                        sleep(1500);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(text, 75, 100);
    }

    public void appendText(String text) {
        this.text += text;
    }
}