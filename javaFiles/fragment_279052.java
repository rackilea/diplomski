import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.net.InetAddress;

public class Exercise1 extends JPanel {
    private JLabel jlblIP = new JLabel("IP= 221.1231.231");
    private JLabel jlblName = new JLabel("Namn = DAMSKDLASM");
    private JLabel jlblHostIP = new JLabel("Host ip --------");
    private JLabel jlblHostName = new JLabel("Host name:");
    private JTextField jtxtfield = new JTextField("");
    private InetAddress ipaddress;

    public Exercise1(){
        setPreferredSize(new Dimension(200,200));
        add(jlblIP);

    }

    public static void main(String[] args) {
        Exercise1 mainjpn = new Exercise1();
        Runnable r = new Runnable() {
            public void run() {
                JFrame jframe = new JFrame();
                jframe.getContentPane().add(mainjpn);
                jframe.pack();
                jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
                jframe.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}