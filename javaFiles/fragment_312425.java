import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        JFrame p = new JFrame("Angora Realms");
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameGUI g = new GameGUI();
        p.add(g);
        p.setSize(640, 800);
        p.setVisible(true);

    }

    public class GameGUI extends JPanel implements ActionListener {

        public Button drawCard = new Button("Draw Card");
        public Image cheetah = null;

        public GameGUI() {
            drawCard.addActionListener(this);
            add(drawCard);
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            Object cause = event.getSource();

            if (cause == drawCard) {
                System.out.println("Ay");
            }
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawString("Hello", 200, 50);
            if (cheetah == null) {
                cheetah = getImage("plains/Cheetah.png");
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(cheetah, 100, 100, 100, 300, this);
            }
        }

        public Image getImage(String path) {

            Image tempImage = null;
            try {
                URL imageURL = GameGUI.class.getResource(path);
                tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            } catch (Exception e) {
                System.out.println("An error occured -" + e.getMessage());
            }

            return tempImage;

        }
    }

}