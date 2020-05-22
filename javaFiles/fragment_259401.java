import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxListeners {

    private JFrame f;
    private JComboBox flyFromCombo;
    private JComboBox flyToCombo;
    private JLabel tripLabel = new JLabel();
    private Object[] itemsFrom;
    private Object[] itemsTo;

    public ComboBoxListeners() {
        itemsFrom = new Object[]{"-", "First - From", "Second - From", "Third - From"};
        itemsTo = new Object[]{"-", "First - To", "Second - To", "Third - To"};
        //flyFromCombo.setPrototypeDisplayValue("################################################");
        flyFromCombo = new JComboBox(itemsFrom);
        flyFromCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = flyFromCombo.getSelectedItem().toString();
                    String str1 = flyToCombo.getSelectedItem().toString();
                    setLabelText(str, str1);
                }
            }
        });
        flyToCombo = new JComboBox(itemsTo);
        flyToCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = flyFromCombo.getSelectedItem().toString();
                    String str1 = flyToCombo.getSelectedItem().toString();
                    setLabelText(str, str1);
                }
            }
        });
        tripLabel.setPreferredSize(new Dimension(400, 30));
        f = new JFrame("ComboBox ItemListeners");
        f.setLayout(new GridLayout(0, 1, 15, 15));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(flyFromCombo);
        f.add(flyToCombo);
        f.add(tripLabel);
        f.setLocation(150, 150);
        f.pack();
        f.setVisible(true);
    }

    private void setLabelText(String str1, String str2) {
        String textForLabel = "";
        String helpStringFirst = str1.trim();
        if (helpStringFirst != null && helpStringFirst.length() > 0) {
            if (!helpStringFirst.equals("-")) {
                textForLabel = "Flight No57. from :   " + helpStringFirst;
            } else {
                textForLabel = "Flight from Un-Know :   ";
            }
        }
        String helpStringSecond = str2.trim();
        if (helpStringSecond != null && helpStringSecond.length() > 0) {
            if (!helpStringSecond.equals("-")) {
                textForLabel = textForLabel + "   --> to :   " + helpStringSecond;
            } else {
                textForLabel += "   to :   Un-Know    ";
            }
        }
        final String pushTextForLabel = textForLabel;
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tripLabel.setText(pushTextForLabel);
            }
        });
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