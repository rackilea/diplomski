import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestNimbus {

    public static void main(String[] args) {
        new TestNimbus();
    }

    public TestNimbus() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                UIDefaults checkBoxDefaults = new UIDefaults();

                Object disabledTextForeground = UIManager.get("CheckBox[Disabled].textForeground");
                Object enabledTextForeground = UIManager.get("CheckBox.foreground");
                checkBoxDefaults.put("CheckBox[Disabled].textForeground", UIManager.get("CheckBox.foreground"));
                checkBoxDefaults.put("CheckBox[Enabled].textForeground", disabledTextForeground);
                checkBoxDefaults.put("CheckBox[Selected+Enabled].textForeground", enabledTextForeground);

                JCheckBox cb1 = new JCheckBox("Option #1");
                JCheckBox cb2 = new JCheckBox("Option #2");
                JCheckBox cb3 = new JCheckBox("Option #3");

                JCheckBox cb4 = new JCheckBox("Normal #1");
                JCheckBox cb5 = new JCheckBox("Normal #2");
                JCheckBox cb6 = new JCheckBox("Normal #3");

                configure(cb1, checkBoxDefaults);
                configure(cb2, checkBoxDefaults);
                configure(cb3, checkBoxDefaults);

                cb1.setSelected(true);
                cb4.setSelected(true);
                cb3.setEnabled(false);
                cb6.setEnabled(false);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = gbc.REMAINDER;
                frame.add(cb1, gbc);
                frame.add(cb2, gbc);
                frame.add(cb3, gbc);
                frame.add(cb4, gbc);
                frame.add(cb5, gbc);
                frame.add(cb6, gbc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            private void configure(JCheckBox checkbox, UIDefaults uiDefaults) {
                checkbox.putClientProperty("Nimbus.Overrides", uiDefaults);
//                checkbox.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }
        });
    }

}