import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.SocketFactory;
import javax.swing.SwingUtilities;

public class MinecraftPinger extends Applet {

    private Boolean connectionWorked = null;
    private boolean pinging = false;

    @Override
    public void init() {

    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            pinging = true;
            startPinging();
        }
    });
    }

    public void paint(Graphics g) {
        if (connectionWorked == null) {
            g.drawString("Attempting Connection...", getWidth()/2-40, getHeight()/2-10);
        } else if (connectionWorked == true) {
            g.setColor(Color.green);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(Color.red);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public void startPinging() {
        while (pinging) {
            try {
                Socket socket = SocketFactory.getDefault().createSocket();
                socket.setSoTimeout(2000);
                socket.connect(new InetSocketAddress("mc.jujucraft.net", 25565));
                socket.close();
                connectionWorked = true;
            } catch (Exception ex) {
                connectionWorked = false;
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}