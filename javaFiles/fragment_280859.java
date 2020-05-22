import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SelectLineDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SelectLineDemo();
            }
        });
    }

    public SelectLineDemo() {
        JFrame frame = new JFrame();
        frame.add(new SelectLinePanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class SelectableLine {
        boolean selected = false;
        Line2D line;

        public SelectableLine(Line2D line) {
            this.line = line;
        }

        public boolean intersects(Rectangle rectangle) {
            return line.intersects(rectangle);
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public Line2D getLine() {
            return line;
        }
    }

    class SelectLinePanel extends JPanel {
        private int selectionRadius = 5;
        private final Color SELECTED_COLOR = Color.BLUE;
        private final Color UNSELECTED_COLOR = Color.BLACK;
        private final Stroke STROKE = new BasicStroke(5.0f);

        private List<SelectableLine> lines = new ArrayList<SelectableLine>();

        public SelectLinePanel() {
            initLines();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point p = e.getPoint();
                    Rectangle selectionRect = getRectangleFromPoint(p);
                    checkIfLinesAreSelected(selectionRect);
                    repaint();
                }
            });
        }

        private void checkIfLinesAreSelected(Rectangle rectangle) {
            for (SelectableLine line : lines) {
                if (line.intersects(rectangle)) {
                    line.setSelected(true);
                } else {
                    line.setSelected(false);
                }
            }
        }

        private Rectangle getRectangleFromPoint(Point p) {
            int x = p.x - selectionRadius;
            int y = p.y - selectionRadius;
            int size = selectionRadius * 2;
            Rectangle selectionRect = new Rectangle(x, y, size, size);
            return selectionRect;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(STROKE);
            for (SelectableLine line : lines) {
                if (line.isSelected()) {
                    g2d.setColor(SELECTED_COLOR);
                } else {
                    g2d.setColor(UNSELECTED_COLOR);
                }
                g2d.draw(line.getLine());
            }
        }

        private void initLines() {
            for (int i = 50; i <= 350; i += 50) {
                lines.add(new SelectableLine(new Line2D.Double(50, i, 350, i)));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}