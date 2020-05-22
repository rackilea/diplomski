import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private JLayeredPane lp;
        private ImagePane imagePane;
        private GridPane gridPane;

        public TestPane() throws IOException {
            setLayout(new GridBagLayout());

            lp = new JLayeredPane();
            lp.setLayout(new GridBagLayout());

            imagePane = new ImagePane();
            gridPane = new GridPane();

            gridPane.setForeground(new Color(255, 255, 255, 64));
            imagePane.setImg(ImageIO.read(...)));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            lp.add(imagePane, gbc);
            lp.add(gridPane, gbc);

            lp.setLayer(imagePane, 0);
            lp.setLayer(gridPane, 10);

            lp.setBackground(Color.RED);
            lp.setBorder(new LineBorder(Color.RED));

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 0.85;
            gbc.fill = gbc.BOTH;

            add(lp, gbc);

            applyDesiredSize(200, 200);

            JButton btn = new JButton("Change");

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weighty = 0.25;
            add(btn, gbc);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField widthTF = new JTextField(4);
                    JTextField heightTF = new JTextField(4);

                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Size: "));
                    panel.add(widthTF);
                    panel.add(new JLabel("x"));
                    panel.add(heightTF);

                    JOptionPane.showMessageDialog(TestPane.this, panel, "Change Size", JOptionPane.PLAIN_MESSAGE);

                    try {
                        int width = Integer.parseInt(widthTF.getText());
                        int height = Integer.parseInt(heightTF.getText());
                        applyDesiredSize(width, height);
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(TestPane.this, "Invalid dimensions", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        protected void applyDesiredSize(int width, int height) {
            Dimension size = new Dimension(width, height);
//          lp.setPreferredSize(size);
            imagePane.setPreferredSize(size);
            gridPane.setPreferredSize(size);

            // Stop GridBagLayout from shrinking the components
            imagePane.setMinimumSize(size);
            gridPane.setMinimumSize(size);

            lp.revalidate();
            lp.repaint();
        }

    }

    public class ImagePane extends JPanel {

        private BufferedImage img;

        public ImagePane() {
        }

        public BufferedImage getImg() {
            return img;
        }

        public void setImg(BufferedImage img) {
            this.img = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }

    }

    public class GridPane extends JPanel {

        private int gridSize = 10;

        public GridPane() {
            setOpaque(false);
        }

        public int getGridSize() {
            return gridSize;
        }

        public void setGridSize(int gridSize) {
            this.gridSize = gridSize;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getForeground());
            for (int x = 0; x < getWidth(); x += gridSize) {
                g2d.drawLine(x, 0, x, getHeight());
            }
            for (int y = 0; y < getWidth(); y += gridSize) {
                g2d.drawLine(0, y, getWidth(), y);
            }
            g2d.dispose();
        }

    }

}