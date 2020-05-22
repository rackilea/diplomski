import java.awt.*;
import javax.swing.*;

public class CustomComponent extends JFrame {

    private static final long serialVersionUID = 1L;

    public CustomComponent() {
        setTitle("Custom Component Test / BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    public void display() {
        add(new CustomComponents0(), BorderLayout.NORTH);
        add(new CustomComponents0(), BorderLayout.CENTER);
        add(new CustomComponents0(), BorderLayout.SOUTH);
        add(new CustomComponents0(), BorderLayout.EAST);
        pack();
        // enforces the minimum size of both frame and component
        setMinimumSize(getMinimumSize());
        setPreferredSize(getPreferredSize());
        setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                CustomComponent main = new CustomComponent();
                main.display();
            }
        };
        javax.swing.SwingUtilities.invokeLater(r);
    }
}

class CustomComponents0 extends JLabel {

    private static final long serialVersionUID = 1L;

    /*@Override
    public Dimension getMinimumSize() {
    return new Dimension(200, 100);
    }

    @Override
    public Dimension getPreferredSize() {
    return new Dimension(300, 200);
    }*/
    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}