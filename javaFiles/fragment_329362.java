import java.awt.*;
import javax.swing.*;


public class NewMain {

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("test");
        frame.setVisible(true);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel emptyArea = new JPanel();
        emptyArea.setPreferredSize(new Dimension(200, 200));
        addItem(panel, new JLabel("Label"), 0, 0, GridBagConstraints.WEST);
        addItem(panel, emptyArea, 0, 0, GridBagConstraints.CENTER);
        frame.add(panel);
    }

    private static void addItem(JPanel p, JComponent gc, int i, int i0, int align) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        c.gridx = i;
        c.gridy = i0;
        c.anchor = align;
        p.add(gc,c);

    }
}