import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JPanelControler {

    private MyJPanel myJpanel;

    public JPanelControler() {
        myJpanel = new MyJPanel();
        myJpanel.createJLabel();
        myJpanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myJpanel.displayJPanel();
            }
        });
    }

    public MyJPanel getMyJpanel() {
        return myJpanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("test");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanelControler ctrl = new JPanelControler();

        frame.add(ctrl.getMyJpanel());
        frame.setVisible(true);
    }
}

class MyJPanel extends JLayeredPane {

    private static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia"
            + "/commons/thumb/f/fc/Gros_Perr%C3%A9.jpg/100px-Gros_Perr%C3%A9.jpg";
    private JButton button;
    private ArrayList<JLabel> labels;
    // a JPanel that contains buttons,... I won't put this class here
    private JPanel panel;

    public MyJPanel() {
        setLayout(null);
        button = new JButton("X");
        button.setBounds(600, 600, 50, 50);
        add(button, JLayeredPane.DEFAULT_LAYER); // add to the bottom
    }

    public void createJLabel() {
        labels = new ArrayList<>();
        JLabel label;
        try {
            URL imgUrl = new URL(IMG_PATH); // ** added to make program work for all
            BufferedImage image = ImageIO.read(imgUrl);
            for (int i = 0; i < 2; i++) {
                label = new JLabel(new ImageIcon(image));
                label.setBounds(i * 100, 50, image.getWidth(), image.getHeight());
                labels.add(label);
                add(label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayJPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false); // ** make sure can see through
        JButton b = new JButton("Ok");
        b.setBounds(0, 0, 100, 50);
        JButton b2 = new JButton("Cancel");
        b2.setBounds(0, 50, 100, 50);
        panel.setBounds(150, 50, 100, 100);
        panel.add(b);
        panel.add(b2);
        add(panel, JLayeredPane.PALETTE_LAYER); // add it above the default layer
        refresh();
    }

    public void refresh() {
        // invalidate(); // not needed
        revalidate();
        repaint();
    }

    public JButton getButton() {
        return this.button;
    }
}