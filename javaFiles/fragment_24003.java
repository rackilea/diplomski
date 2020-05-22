import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Client();
            }
        });
    }

    Client() {
        String[] args = {"ggg", "vvv"};

        try {
            ClientGUI.createAndShowGUI();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class ClientGUI extends JPanel implements ActionListener {

    private static JButton btnForward = new JButton("Forward"),
            btnBackward = new JButton("Backward");



    public ClientGUI() throws MalformedURLException {
        setLayout(new BorderLayout());

        add(btnForward, BorderLayout.CENTER);

        btnForward.addActionListener(this);
        btnBackward.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnForward) {
            remove(btnForward);

            add(btnBackward, BorderLayout.CENTER);

            revalidate();
            repaint();
        } else if (e.getSource() == btnBackward) {
            remove(btnBackward);

            add(btnForward);

            revalidate();
            repaint();
        }
    }

    public static void createAndShowGUI() throws MalformedURLException {
        JFrame frame = new JFrame("ClientGUI");

        frame.setMinimumSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClientGUI());

        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}