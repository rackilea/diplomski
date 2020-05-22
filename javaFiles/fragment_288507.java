import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestHeavyweightLightweight {

    public class MyLayoutManager implements LayoutManager2 {

        private Map<Component, Rectangle> constraints = new LinkedHashMap<Component, Rectangle>();

        @Override
        public void addLayoutComponent(String name, Component comp) {
            constraints.put(comp, comp.getBounds());
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            constraints.remove(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Rectangle rect = new Rectangle();
            for (Rectangle r : constraints.values()) {
                rect = rect.union(r);
            }
            return rect.getSize();
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            for (Map.Entry<Component, Rectangle> e : constraints.entrySet()) {
                e.getKey().setBounds(e.getValue());
            }
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints instanceof Rectangle) {
                this.constraints.put(comp, (Rectangle) constraints);
            } else {
                addLayoutComponent((String) null, comp);
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0;
        }

        @Override
        public void invalidateLayout(Container target) {

        }

        public void setConstraints(Component component, Rectangle rect) {
            constraints.put(component, rect);
        }

        public class MouseDragger extends MouseAdapter {
            private Point lastLocation;
            private Component draggedComponent;

            @Override
            public void mousePressed(MouseEvent e) {
                draggedComponent = e.getComponent();
                lastLocation = SwingUtilities.convertPoint(draggedComponent, e.getPoint(), draggedComponent.getParent());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point location = SwingUtilities.convertPoint(draggedComponent, e.getPoint(), draggedComponent.getParent());
                if (draggedComponent.getParent().getBounds().contains(location)) {
                    Point newLocation = draggedComponent.getLocation();
                    newLocation.translate(location.x - lastLocation.x, location.y - lastLocation.y);
                    newLocation.x = Math.max(newLocation.x, 0);
                    newLocation.x = Math.min(newLocation.x, draggedComponent.getParent().getWidth() - draggedComponent.getWidth());
                    newLocation.y = Math.max(newLocation.y, 0);
                    newLocation.y = Math.min(newLocation.y, draggedComponent.getParent().getHeight() - draggedComponent.getHeight());
                    setConstraints(draggedComponent, new Rectangle(newLocation, draggedComponent.getSize()));
                    if (draggedComponent.getParent() instanceof JComponent) {
                        ((JComponent) draggedComponent.getParent()).revalidate();
                    } else {
                        draggedComponent.getParent().invalidate();
                        draggedComponent.getParent().validate();
                    }
                    lastLocation = location;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lastLocation = null;
                draggedComponent = null;
            }

            public void makeDraggable(Component component) {
                component.addMouseListener(this);
                component.addMouseMotionListener(this);
            }

        }

    }

    private Canvas canvas;
    private JPanel panel;

    protected void createAndShowGUI() {
        JFrame frame = new JFrame(TestHeavyweightLightweight.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        panel = new JPanel();
        MyLayoutManager mgr = new MyLayoutManager();
        panel.setLayout(mgr);
        panel.add(canvas, new Rectangle(20, 40, 300, 300));
        MyLayoutManager.MouseDragger mouseDragger = mgr.new MouseDragger();
        mouseDragger.makeDraggable(canvas);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestHeavyweightLightweight().createAndShowGUI();
            }
        });
    }

}