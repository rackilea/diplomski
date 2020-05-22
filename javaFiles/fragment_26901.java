import javax.swing.*;
import java.awt.event.*;

public class ComboBoxTest {

    JComboBox combo;
    JTextField txt;

    public static void main(String[] args) {
        new ComboBoxTest();
    }

    public ComboBoxTest() {
        String items[] = {"Item1", "item1"};
        JFrame frame = new JFrame("JComboBox Case-sensitivity Test");
        JPanel panel = new JPanel();
        combo = new JComboBox(items);
        combo.setEditable(true);

        txt = new JTextField(10);
        panel.add(combo);
        panel.add(txt);
        frame.add(panel);
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                String str = (String) combo.getSelectedItem();
                txt.setText(str);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setVisible(true);
    }
}