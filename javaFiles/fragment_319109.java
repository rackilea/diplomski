import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class MainDishPanel extends JPanel {

    JCheckBox box1 = new JCheckBox("Hamburger 5 dollars"), box2 = new JCheckBox("Pizza 5 dollars"),
        box3 = new JCheckBox("French Hot dog 5 dollars");

    MainDishPanel() {
        setOpaque(true);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3, 1));

        box1.setBackground(Color.WHITE); // or box1.setOpaque(false);
        box2.setBackground(Color.WHITE);
        box3.setBackground(Color.WHITE);

        add(box1);
        add(box2);
        add(box3);
        setVisible(true);
    }
}