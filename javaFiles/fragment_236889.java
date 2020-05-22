import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel center;

        public TestPane() {
            setLayout(new BorderLayout());
            JButton btnNewButton = new JButton("View the graph");
            center = new JPanel();
            center.setPreferredSize(new Dimension(400, 400));
            add(center);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    remove(center);

                    //a= Integer.parseInt(cofficient_a.getText());
                    //b= Integer.parseInt(cofficient_b.getText());
                    //c= Integer.parseInt(cofficient_c.getText());
                    //d= Integer.parseInt(cofficient_d.getText());
                    //e= Integer.parseInt(cofficient_e.getText());
                    center = new Drawfunction();
                    add(center);
                    revalidate();
                    repaint();

                }

            });
            add(btnNewButton, BorderLayout.NORTH);
        }

        public class Drawfunction extends JPanel {

            public Drawfunction() {
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.red);
                g2d.drawLine(0, 200, 400, 200);
                g2d.drawLine(200, 0, 200, 400);
                g2d.dispose();
            }

        }

    }
}