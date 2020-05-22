import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Example01 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame jf = new JFrame();
                MainPanel mainPanel = new MainPanel();
                jf.add(mainPanel);
                jf.setSize(640, 480);
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
    }
}

class MainPanel extends JPanel {
    StarShape check1 = new StarShape();
    StarShape check2 = new StarShape();

    public MainPanel() {
        check1.setName("check1");
        check2.setName("check2");
        check1.addMouseListener(new MyMouseListener(check1));
        check2.addMouseListener(new MyMouseListener(check2));
        this.add(check1);
        this.add(check2);
    }
}

class StarShape extends JComponent {
    public StarShape() {
        this.setPreferredSize(new Dimension(100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        int x = 0;
        int y = 0;
        int width = this.getWidth() - 1;
        int height = this.getHeight() - 1;
        g2d.draw(new Rectangle(x, y, width, height));
    }
}

class MyMouseListener implements MouseListener {
    private final JComponent component;

    public MyMouseListener(JComponent component) {
        this.component = component;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked: " + component.getName());
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered: " + component.getName());
        Dimension preferredSize = component.getPreferredSize();
        preferredSize.height += 20;
        preferredSize.width += 20;
        component.setPreferredSize(preferredSize);
        component.invalidate();
        SwingUtilities.getWindowAncestor(component).validate();
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited: " + component.getName());
        Dimension preferredSize = component.getPreferredSize();
        preferredSize.height -= 20;
        preferredSize.width -= 20;
        component.setPreferredSize(preferredSize);
        component.invalidate();
        SwingUtilities.getWindowAncestor(component).validate();
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed: " + component.getName());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased: " + component.getName());
    }
}