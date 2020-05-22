import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MinimumSize extends JFrame {

    private static final long serialVersionUID = 1L;

    public MinimumSize() {
        setTitle("Custom Component Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        add(new CustomComponent());
        pack();        
        setMinimumSize(getSize());// enforces the minimum size of both frame and component
        setVisible(true);
    }

    public static void main(String[] args) {
        MinimumSize main = new MinimumSize();
        main.display();
    }
}

class CustomComponent extends JComponent {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}