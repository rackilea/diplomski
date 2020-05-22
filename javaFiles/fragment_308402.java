import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MainGui {
    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JButton newBut = new JButton("New Game");
    JButton continueBut = new JButton("Continue");
    JButton exitBut = new JButton("Exit");
    JLabel backImage = new JLabel(new ImageIcon(
            getClass().getResource("images.jpg")));

    public MainGui() {
        backImage.setLayout(new GridLayout(3,1));
        frame.setContentPane(backImage);
        JPanel p1= new JPanel(new GridBagLayout());
        p1.setOpaque(false);
        p1.add(newBut);
        JPanel p2 = new JPanel(new GridBagLayout());
        p2.setOpaque(false);
        p2.add(continueBut);
        JPanel p3 = new JPanel(new GridBagLayout());
        p3.setOpaque(false);
        p3.add(exitBut);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 275);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                MainGui mainGui = new MainGui();
            }
        });
    }
}