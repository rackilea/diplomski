import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawStuff extends JFrame {

    public static void main(String[] args) {
        new DrawStuff();
    }

    public DrawStuff() {
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
                frame.add(new ControlPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ControlPane extends JPanel {

        private JRadioButton circle;
        private JRadioButton square;

        private DrawPane drawPane;

        public ControlPane() {
            setLayout(new GridBagLayout());

            ButtonGroup bg = new ButtonGroup();
            circle = new JRadioButton("Circle");
            square = new JRadioButton("Square");

            bg.add(circle);
            bg.add(square);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;

            JPanel shape = new JPanel();
            shape.add(circle);
            shape.add(square);
            add(shape, gbc);

            JButton draw = new JButton("Draw");
            draw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (circle.isSelected()) {
                        drawPane.setDrawableShape(DrawableShape.CIRCLE);
                    } else if (square.isSelected()) {
                        drawPane.setDrawableShape(DrawableShape.SQUARE);
                    }
                }
            });

            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(draw, gbc);

            drawPane = new DrawPane();

            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = gbc.BOTH;
            add(drawPane, gbc);
        }

    }

    public enum DrawableShape {
        CIRCLE,
        SQUARE
    }

    public class DrawPane extends JPanel {

        private DrawableShape drawableShape;

        public DrawPane() {
        }

        public void setDrawableShape(DrawableShape drawableShape) {
            this.drawableShape = drawableShape;
            repaint();
        }

        public DrawableShape getDrawableShape() {
            return drawableShape;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            DrawableShape shape = getDrawableShape();
            if (shape != null) {
                int width = getWidth() - 20;
                int height = getHeight() - 20;
                int size = Math.min(width, height);

                int x = (getWidth() - size) / 2;
                int y = (getHeight() - size) / 2;
                if (shape == DrawableShape.CIRCLE) {
                    g2d.fillOval(x, y, size, size);
                } else if (shape == DrawableShape.SQUARE) {
                    g2d.fillRect(x, y, size, size);
                }
            }
            g2d.dispose();
        }

    }
}