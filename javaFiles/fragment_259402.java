import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ComboBoxListeners {

    private JFrame f;
    private JComboBox flyFromCombo;
    private JLabel tripLabel = new JLabel();

    public ComboBoxListeners() {
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (int i = 1; i <= 100; ++i) {
            ageList.add(i);
        }
        DefaultComboBoxModel modelAge = new DefaultComboBoxModel();
        for (Integer i : ageList) {
            modelAge.addElement(i);
        }
        flyFromCombo = new JComboBox(modelAge);
        flyFromCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = flyFromCombo.getSelectedItem().toString();
                    tripLabel.setText("Selected Age From JComboBox is :   " + str);
                }
            }
        });
        tripLabel.setPreferredSize(new Dimension(400, 30));
        f = new JFrame("ComboBox ItemListeners");
        f.setLayout(new GridLayout(0, 1, 15, 15));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(flyFromCombo);
        f.add(tripLabel);
        f.setLocation(150, 150);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ComboBoxListeners comboBoxListeners = new ComboBoxListeners();
            }
        });
    }
}