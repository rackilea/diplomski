import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class AppFrame {

    public static void main(String[] args) {
        new AppFrame();
    }

    public AppFrame() {
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
                frame.setLayout(new GridLayout(2, 2));
                frame.add(new Warcaby());
                frame.add(new Warcaby());
                frame.add(new Warcaby());
                frame.add(new Warcaby());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Warcaby extends JPanel {

        public Warcaby() {
            setBackground(Color.WHITE);
            setBorder(new EmptyBorder(5, 5, 5, 5));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

//            setBackground(Color.WHITE);
            Graphics2D g2 = (Graphics2D) g;

            Insets insets = getInsets();
            int horontialPadding = insets.left + insets.right;
            int verticalPadding = insets.top + insets.bottom;

            int width = getWidth() - horontialPadding;
            int height = getHeight() - verticalPadding;

            int size = Math.min(width, height) / 10;

            int xOffset = insets.left + ((width - (size * 10)) / 2);
            int yOffset = insets.top + ((height - (size * 10)) / 2);

            for (int vertical = 0; vertical < 10; vertical++) {
                for (int horzontial = 0; horzontial < 10; horzontial++) {
                    int x = horzontial * size;
                    int y = vertical * size;
                    g2.setColor(Color.WHITE);
                    if (vertical % 2 == 0) {
                        if (horzontial % 2 == 0) {
                            g2.setColor(Color.BLACK);
                        }
                    } else if (horzontial % 2 != 0) {
                        g2.setColor(Color.BLACK);
                    }
                    g2.fillRect(xOffset + x, yOffset + y, size, size);
                }
            }
            g2.setColor(Color.BLACK);
            g2.drawRect(xOffset, yOffset, size * 10, size * 10);
        }
    }
}