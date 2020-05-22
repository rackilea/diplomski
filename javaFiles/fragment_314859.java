import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestSocket {

    private SocketThread socketThread;

    public static void main(String[] args) {
        new TestSocket();
    }

    public TestSocket() {
        socketThread = new SocketThread();
        socketThread.start();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(new JLabel("Close me if you dare"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        socketThread.stopThatSocket();
                    }
                });
            }
        });
    }

    public class SocketThread extends Thread {

        private volatile boolean flagToSetWhenYouWantToStop = true;
        private ServerSocket socket = null;

        public SocketThread() {
            setName("Socket");
            setDaemon(true);
        }

        public void stopThatSocket() {
            flagToSetWhenYouWantToStop = false;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
            interrupt();
            try {
                join();
            } catch (InterruptedException ex) {
            }
        }

        @Override
        public void run() {

            try {
                socket = new ServerSocket(1234);
                while (flagToSetWhenYouWantToStop) {
                    Socket accept = socket.accept();
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }
}