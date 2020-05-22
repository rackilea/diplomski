import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.DefaultButtonModel;
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

        public TestPane() {
            setLayout(new GridBagLayout());
            HexagonButton btn = new HexagonButton();
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(Arrays.toString(btn.getSelectedObjects()));
                    System.out.println(e.getActionCommand());
                }
            });
            add(btn);
        }

    }

    public class HexagonButton extends AbstractButton {

        public static final String TOP_RIGHT_QUAD = "Top.right";
        public static final String TOP_QUAD = "Top";
        public static final String TOP_LEFT_QUAD = "Top.left";
        public static final String BOTTOM_LEFT_QUAD = "Bottom.left";
        public static final String BOTTOM_QUAD = "Bottom";
        public static final String BOTTOM_RIGHT_QUAD = "Bottom.right";

        private Shape top;
        private Shape topRight;
        private Shape topLeft;
        private Shape bottomLeft;
        private Shape bottomRight;
        private Shape bottom;

        private Map<String, Shape> paths;
        private String selectedQuad;

        public HexagonButton() {
            setModel(new DefaultButtonModel());
            createPaths();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    String previousQuad = selectedQuad;
                    selectedQuad = null;
                    for (String quad : paths.keySet()) {

                        Shape shape = paths.get(quad);
                        if (shape.contains(e.getPoint())) {
                            getModel().setPressed(true);
                            getModel().setArmed(true);
                            selectedQuad = quad;
                            if (!selectedQuad.equals(previousQuad)) {
                                fireActionPerformed(new ActionEvent(HexagonButton.this, ActionEvent.ACTION_PERFORMED, selectedQuad));
                            }
                            break;
                        }

                    }
                    repaint();

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    getModel().setArmed(false);
                    getModel().setPressed(false);
                }
            });

        }

        @Override
        public Object[] getSelectedObjects() {
            return new Object[]{selectedQuad};
        }

        @Override
        public void invalidate() {
            super.invalidate();
            createPaths();
        }

        protected void createPaths() {
            topRight = create(0d, -60d);
            top = create(-60d, -120d);
            topLeft = create(-120d, -180d);
            bottomLeft = create(-180d, -240d);
            bottom = create(-240d, -300d);
            bottomRight = create(-300d, -360d);

            paths = new HashMap<>(6);
            paths.put(TOP_RIGHT_QUAD, topRight);
            paths.put(TOP_QUAD, top);
            paths.put(TOP_LEFT_QUAD, topLeft);
            paths.put(BOTTOM_LEFT_QUAD, bottomLeft);
            paths.put(BOTTOM_QUAD, bottom);
            paths.put(BOTTOM_RIGHT_QUAD, bottomRight);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(104, 104);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            Graphics2D g2d = (Graphics2D) g.create();
            if (selectedQuad != null) {
                Shape path = paths.get(selectedQuad);
                g2d.setColor(UIManager.getColor("List.selectionBackground"));
                g2d.fill(path);
            }
            g2d.setColor(getForeground());
            g2d.draw(topRight);
            g2d.draw(top);
            g2d.draw(topLeft);
            g2d.draw(bottomLeft);
            g2d.draw(bottom);
            g2d.draw(bottomRight);
            g2d.dispose();
        }

        public Shape create(double startAngle, double endAngle) {

            double width = getWidth();
            double height = getHeight();

            double radius = Math.min(width, height) / 2;

            double xOffset = width - radius;
            double yOffset = height - radius;

            double startX = xOffset + radius * (Math.cos(Math.toRadians(startAngle)));
            double startY = yOffset + radius * (Math.sin(Math.toRadians(startAngle)));

            double endX = xOffset + radius * (Math.cos(Math.toRadians(endAngle)));
            double endY = yOffset + radius * (Math.sin(Math.toRadians(endAngle)));

            Path2D path = new Path2D.Double();
            path.moveTo(xOffset, yOffset);
            path.lineTo(startX, startY);
            path.lineTo(endX, endY);
            path.closePath();

            return path;

        }

    }

    public static class TriangleButton extends JButton {

        final static double side_len = 52; //Change for variable triangle size
        final static double y_offset = (Math.sqrt(3) * side_len / 2);
        private Shape triangle;

        public TriangleButton(int spot) {
            triangle = createTriangle(spot);
        }

        @Override
        public void paintBorder(Graphics g) {
            super.paintBorder(g);
            ((Graphics2D) g).draw(triangle);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).fill(triangle);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension((int) side_len, (int) y_offset);
        }

        @Override
        public boolean contains(int x, int y) {
            return triangle.contains(x, y);
        }

        private Shape createTriangle(int spot) {
            Polygon p = new Polygon();
            p.addPoint(0, 0);
            p.addPoint((int) side_len, 0);
            p.addPoint((int) side_len / 2, (int) (y_offset));
            return p;
        }
    }
}