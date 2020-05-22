import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
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

                JPanel master = new JPanel(new PropertionalLayoutManager());
                master.add(new TestPane(), "left");
                master.add(new DrawPane(), "center");
                master.add(new TestPane(), "right");

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(master);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PropertionalLayoutManager implements LayoutManager {

        private Component left;
        private Component right;
        private Component center;

        @Override
        public void addLayoutComponent(String name, Component comp) {
            if ("center".equals(name)) {
                center = comp;
            } else if ("left".equals(name)) {
                left = comp;
            } else if ("right".equals(name)) {
                right = comp;
            }
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        public Dimension getSize(Dimension leftSize, Dimension centerSize, Dimension rightSize) {


            Dimension size = new Dimension();
            if (leftSize != null && right != null) {

                int width = leftSize.width;
                int height = leftSize.height;

                size.width = Math.max(width, rightSize.width) * 2;
                size.height = Math.max(height, rightSize.height);

            } else if (leftSize != null) {

                size.width = leftSize.width;
                size.height = leftSize.height;

            } else if (right != null) {

                size.width = rightSize.width;
                size.height = rightSize.height;

            }

            if (center != null) {

                size.width += centerSize.width;
                size.height = Math.max(centerSize.height, size.height);

            }

            return size;

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {

            Dimension leftSize = left == null ? null : left.getPreferredSize();
            Dimension centerSize = right == null ? null : right.getPreferredSize();
            Dimension rightSize = center == null ? null : center.getPreferredSize();

            return getSize(leftSize, centerSize, rightSize);

        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {

            Dimension leftSize = left == null ? null : left.getMinimumSize();
            Dimension centerSize = right == null ? null : right.getMinimumSize();
            Dimension rightSize = center == null ? null : center.getMinimumSize();

            return getSize(leftSize, centerSize, rightSize);

        }

        @Override
        public void layoutContainer(Container parent) {

            // Get rid of anything else that might have been added...
            for (Component comp : parent.getComponents()) {

                comp.setBounds(0, 0, 0, 0);

            }

            int width = parent.getWidth();
            int height = parent.getHeight();

            int outterWidth = height / (3 / 1);

            if (left != null) {

                left.setBounds(0, 0, outterWidth, height);

            }

            if (right != null) {

                right.setBounds(width - outterWidth, 0, outterWidth, height);

            }

            if (center != null) {

                center.setBounds(outterWidth, 0, width - (outterWidth * 2), height);

            }

        }

    }

    public class DrawPane extends JPanel {

        public DrawPane() {
            setBackground(Color.BLUE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - (getWidth() / 4)) / 2;
            int y = (getHeight()- (getHeight() / 4)) / 2;
            g.setColor(Color.GRAY);
            g.fillOval(x, y, getWidth() / 4, getHeight() / 4);
        }

    }

    public class TestPane extends JPanel {

        private JLabel size;

        public TestPane() {
            setBackground(Color.GREEN);
            setLayout(new GridBagLayout());
            size = new JLabel();
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    size.setText(getWidth() + "x" + getHeight());
                }
            });
            add(size);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 300);
        }

    }

}