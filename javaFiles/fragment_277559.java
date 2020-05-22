import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author dic19
 */
public class JSideBar extends JComponent {

    private final JPanel content;

    public JSideBar(boolean scrollable) {
        super();

        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        this.setLayout(new BorderLayout());

        if(scrollable) {
            this.add(new JScrollPane(content));
        } else {
            this.add(content);
        }

    }

    /**
     * Adds a component to this side bar.
     * 
     * @param comp The component.
     * @param alignment One of {@code Component.LEFT_ALIGNMENT, Component.CENTER_ALIGNMENT, Component.RIGHT_ALIGNMENT}
     * 
     * @see java.awt.Component#LEFT_ALIGNMENT
     * @see java.awt.Component#CENTER_ALIGNMENT
     * @see java.awt.Component#RIGHT_ALIGNMENT
     */
    public void addItem(JComponent comp, float alignment) {
        comp.setAlignmentX(alignment);
        content.add(comp);
        if(content.isShowing()) {
            revalidate();
            repaint();
        }
    }

    /**
     * Adds a vertical space to this side bar.
     * @param height Height of vertical space.
     */
    public void addVerticalSpace(int height) {
        content.add(Box.createVerticalStrut(height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics graphics = g.create();
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.dispose();
    }
}