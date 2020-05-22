import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGUI extends JFrame {

    private Visualization v;
    private GridBagConstraints constraints = new GridBagConstraints();
    private JRadioButton temperature, pluviometry;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Visualization v = new Visualization();
                TestGUI frame = new TestGUI(v);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public TestGUI(Visualization v) {
        this.setTitle("Pluviometry Data Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.v = v;

        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        add(new JRadioButton("Cool stuff"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill=GridBagConstraints.BOTH;

        this.add(v, constraints);
        //this.add(new JRadioButton("Temperature", true),constraints);
        this.pack();
        this.setVisible(true);
    }

    public static class Visualization extends JComponent {

        private int y_axis = 210;
        private int x_axis = 450;

        public Visualization() {
        }

        @Override
        public void paintComponent(Graphics g) {
            int width = getWidth();
            int height = getHeight();

            g.setColor(new Color(255, 78, 23));
            g.drawLine(50, 20, 50, 230);
            g.drawLine(50, 230, 500, 230);
            for (int i = 100; i <= 500; i += 50) {
                g.drawLine(i, 230, i, 240);
            }
            for (int i = 180; i > 0; i -= 40) {
                g.drawLine(50, i, 40, i);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500 + 50, 230 + 50);
        }
    }
}