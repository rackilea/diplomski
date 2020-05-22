import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static Griglia g[][] = new Griglia[3][3];

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new GridLayout(3, 3));
                for (int i = 0; i < 3; i++) {
                    for (int ii = 0; ii < 3; ii++) {
                        g[i][ii] = new Griglia();
//                        g[i][ii].setLocation(i * 155, ii * 155);
//                g[i][ii].repaint();
//                g[i][ii].addMouseListener(lis);
                        frame.add(g[i][ii]);
//                g[i][ii].setVisible(true);
//                g[i][ii].repaint();

//                f.repaint();
                    }
                }

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

/////////////////////////////////////////////////////////////////////
    public static class Griglia extends JPanel {

        Casella c[][] = new Casella[3][3];
        int flag = 0;

        public Griglia() {
//            this.setSize(150, 150);
//            this.setLayout(null);
            this.setBackground(Color.black);

            setLayout(new GridLayout(3, 3));

            for (int i = 0; i < 3; i++) {
                for (int ii = 0; ii < 3; ii++) {
                    c[i][ii] = new Casella();
//                    c[i][ii].setLocation(i * 50, ii * 50);
//                    c[i][ii].repaint();
                    this.add(c[i][ii]);
//                    this.repaint();
                }
            }
        }
    }

////////////////////////////////////////////////////////////////////////////
    public static class Casella extends JButton {

        int flag = 0;

        public Casella() {
//            this.setSize(50, 50);
            this.setBackground(Color.LIGHT_GRAY);
//            this.setVisible(true);
        }

    }
}