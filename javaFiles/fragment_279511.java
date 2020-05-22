import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

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
                frame.add(new BasePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BasePane extends JPanel {

        public BasePane() {
            TestPane top = new TestPane();
            TestPane bottom = new TestPane();

//          top.setBorder(new LineBorder(Color.RED));
//          bottom.setBorder(new LineBorder(Color.BLUE));

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 0.3;

            add(top, gbc);

            gbc.gridy++;
            gbc.weighty = 0.7;

            add(bottom, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }


    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            Dimension mySize = getSize();
            Dimension parentSize = getParent().getSize();

            String widthPer = NumberFormat.getPercentInstance().format((float) mySize.width / (float) parentSize.width);
            String heightPer = NumberFormat.getPercentInstance().format((float) mySize.height / (float) parentSize.height);

            String[] text = new String[]{
                "Me = " + mySize.width + "x" + mySize.height,
                "Parent = " + parentSize.height + "x" + parentSize.height,
                "Perctange = " + widthPer + "x" + heightPer
            };

            FontMetrics fm = g2d.getFontMetrics();
            int y = (getHeight() - (fm.getHeight() * text.length)) / 2;
            for (String value : text) {
                int x = (getWidth() - fm.stringWidth(value)) / 2;
                g2d.drawString(value, x, y + fm.getAscent());
                y += fm.getHeight();
            }

            g2d.dispose();
        }

    }

}