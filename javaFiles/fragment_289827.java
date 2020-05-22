import javax.swing.*;
import java.awt.event.*;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);
        String[] list = {"1", "2", "3", "4",};
        JComboBox comb = new JComboBox(list);
        final JPopupMenu pop = new JPopupMenu();
        pop.add(comb);
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
                pop.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}