import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

                JPanel master = new JPanel(new SquareLayoutManager());
                master.setBackground(Color.BLUE);
                master.add(new DrawPane());

                JPanel green = new JPanel();
                green.setBackground(Color.GREEN);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 0.66666666666667;
                gbc.fill = GridBagConstraints.BOTH;
                frame.add(master, gbc);

                gbc.gridy++;
                gbc.weighty = 0.33333333333333;
                frame.add(green, gbc);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SquareLayoutManager implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {

            int width = 0;
            int height = 0;
            for (Component comp : parent.getComponents()) {
                width = Math.max(comp.getPreferredSize().width, width);
                height = Math.max(comp.getPreferredSize().width, height);
            }

            // You could define rows and columns and blah, blah, blah, but I'm to lazy...

            return new Dimension(Math.max(width, height) * parent.getComponentCount(), Math.max(width, height));

        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {

            return preferredLayoutSize(parent);

        }

        @Override
        public void layoutContainer(Container parent) {

            Insets insets = parent.getInsets();
            int size = (parent.getHeight() - (insets.bottom + insets.top));
            int x = (parent.getWidth() - (insets.left + insets.right) - size) / 2;
            int y = insets.top;
            for (Component comp : parent.getComponents()) {
                comp.setBounds(x, y, size, size);
                x += size; // Could define a gap, but, lazy...
            }

        }

    }

    public class DrawPane extends JPanel {

        public DrawPane() {
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - (getWidth() / 4)) / 2;
            int y = (getHeight() - (getHeight() / 4)) / 2;
            g.setColor(Color.GRAY);
            g.fillOval(x, y, getWidth() / 4, getHeight() / 4);
        }

    }

}