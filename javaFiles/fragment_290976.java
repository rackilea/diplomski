import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestLimitedDrag {

    public static class MouseDragger extends MouseAdapter {
        private Point startPoint;
        private Component draggedObject;

        @Override
        public void mousePressed(MouseEvent e) {
            draggedObject = (Component) e.getSource();
            startPoint = SwingUtilities.convertPoint(draggedObject, e.getPoint(), draggedObject.getParent());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point location = SwingUtilities.convertPoint(draggedObject, e.getPoint(), draggedObject.getParent());
            if (draggedObject.getParent().getBounds().contains(location)) {
                Point newLocation = draggedObject.getLocation();
                newLocation.translate(location.x - startPoint.x, location.y - startPoint.y);
                newLocation.x = Math.max(newLocation.x, 0);
                newLocation.x = Math.min(newLocation.x, draggedObject.getParent().getWidth() - draggedObject.getWidth());
                newLocation.y = Math.max(newLocation.y, 0);
                newLocation.y = Math.min(newLocation.y, draggedObject.getParent().getHeight() - draggedObject.getHeight());
                draggedObject.setLocation(newLocation);
                startPoint = location;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            startPoint = null;
            draggedObject = null;
        }

        public void makeDraggable(Component component) {
            component.addMouseListener(this);
            component.addMouseMotionListener(this);
        }

    }

    private void initUI() {
        JFrame frame = new JFrame(TestLimitedDrag.class.getSimpleName());
        frame.setLayout(null);
        MouseDragger dragger = new MouseDragger();
        JLabel labelToDrag = new JLabel("Drag me");
        dragger.makeDraggable(labelToDrag);
        frame.add(labelToDrag);
        labelToDrag.setSize(labelToDrag.getPreferredSize());
        labelToDrag.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestLimitedDrag().initUI();
            }
        });
    }

}