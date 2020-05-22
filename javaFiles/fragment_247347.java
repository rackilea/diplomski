package sudoku;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class UIToolBarContainer extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -5279534877002998610L;

    private Point mouse;
    private Point mouseClickOffset;
    private Component dragged;
    private BufferedImage draggedImage;

    public UIToolBarContainer() {

        super();

        mouse = new Point(0, 0);
        mouseClickOffset = new Point(0, 0);
        dragged = null;
        draggedImage = null;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(createToolBar("label1", Color.red));
        this.add(createToolBar("label2", Color.green));
        this.add(createToolBar("label3", Color.cyan));
        this.add(createToolBar("label4", Color.yellow));
    }

    private JToolBar createToolBar(String name, Color color) {

        JToolBar toolbar = new JToolBar();

        for (MouseListener listener : toolbar.getMouseListeners()) {
            toolbar.removeMouseListener(listener);
        }

        for (MouseMotionListener listener : toolbar.getMouseMotionListeners()) {
            toolbar.removeMouseMotionListener(listener);
        }

        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolbar.setBackground(color);
        toolbar.setFloatable(true);
        toolbar.add(new JLabel(name));
        toolbar.addMouseListener(this);
        toolbar.addMouseMotionListener(this);

        return toolbar;
    }

    /**
     * Get the insertion index based on the closest mouse x position.
     * @return positive index on success, negative index on failure.
     */
    private int getInsertionIndex() {

        if (getComponentCount() <= 1) {
            return -1;
        }

        Component lastComponent = getComponent(getComponentCount() - 1);
        Point last = SwingUtilities.convertPoint(lastComponent, 0, 0, this);

        if (mouse.x > (last.x + lastComponent.getWidth() / 2)) {
            return getComponentCount();
        }

        for (int i = 0; i < getComponentCount(); i++) {
            Component component = getComponent(i);
            Point position = SwingUtilities.convertPoint(component, 0, 0, this);
            if (mouse.x < (position.x + component.getWidth() / 2)) {            
                return i;
            }
        }

        return -2;
    }

    /**
     * Get the position of the insertion for the preview.
     * @param index the component index we will be inserting at.
     * @return returns the location of the insertion preview, null if index is invalid.
     */
    private Point getInsertionIndexLocation(int index, int offset) {

        if (index < 0 || index > getComponentCount()) {
            return null;
        }

        if (index == getComponentCount()) {
            Component lastComponent = getComponent(getComponentCount() - 1);
            Point position = SwingUtilities.convertPoint(lastComponent, 0, 0, this);
            position.x += lastComponent.getWidth() + offset;
            return position;
        }

        Component component = getComponent(index);
        Point position = SwingUtilities.convertPoint(component, 0, 0, this);
        position.x -= offset;
        return position;
    }

    /**
     * Generate an image of a given component with a given alpha, used for ghost effect when dragging.
     * @param c the component to create an image of
     * @param alpha the alpha amount to apply on the image
     * @return an image of a given component
     */
    public static BufferedImage GetComponentAsImage(Component c, float alpha) {

        BufferedImage buffer = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        int rule = AlphaComposite.SRC_OVER;
        Composite comp = AlphaComposite.getInstance(rule, alpha);
        g2d.setComposite(comp);
        c.paintAll(g2d);
        g2d.dispose();

        return buffer;
    }

    @Override
    protected void paintChildren(Graphics g) {

        super.paintChildren(g);

        if (dragged != null && draggedImage != null) {

            int insertionIndex = getInsertionIndex();
            Point insertionLocation = getInsertionIndexLocation(insertionIndex, 3);
            if (insertionLocation != null) {
                g.setColor(Color.black);
                g.drawLine(
                    insertionLocation.x,
                    insertionLocation.y, 
                    insertionLocation.x,
                    insertionLocation.y + getComponent(0).getHeight()
                );
            }

            int x = mouse.x - mouseClickOffset.x;
            int y = mouse.y - mouseClickOffset.y;
            g.drawImage(draggedImage, x, y, null);
            g.setColor(Color.gray);
            g.drawRect(x, y, dragged.getWidth(), dragged.getHeight());
        }
    }

    /**
     * converts the mouse position from the relative child to the parent coordinate.
     * @param e
     */
    private void updateMouseLocation(MouseEvent e) {
        mouse = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), this);
    }

    /**
     * find the index of the component
     * @param c the component we are trying to get the index
     * @return returns the index, -1 if not found.
     */
    private int getComponentIndex(Component c) {

        for (int i = 0; i < getComponentCount(); i++) {
            if (c == getComponent(i)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragged = e.getComponent();
        updateMouseLocation(e);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMouseLocation(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        dragged = e.getComponent();
        draggedImage = GetComponentAsImage(dragged, 0.5f);
        updateMouseLocation(e);
        mouseClickOffset = e.getPoint();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (dragged != null && draggedImage != null) {
            int insertionIndex = getInsertionIndex();
            if (insertionIndex == getComponentCount()) {
                remove(dragged);
                add(dragged);
            } else if (insertionIndex >= 0 && insertionIndex < getComponentCount()) {

                int dragIndex = getComponentIndex(dragged);
                if (dragIndex != insertionIndex) {
                    if (dragIndex > insertionIndex) {
                        // right to left
                        remove(dragged);
                        add(dragged, insertionIndex);
                    } else {
                        // left to right
                        remove(dragged);
                        add(dragged, insertionIndex - 1);
                    }
                }
            }
        }

        dragged = null;
        draggedImage = null;

        revalidate();
        repaint();
    }
}