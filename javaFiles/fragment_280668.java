import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FileChooserUI;

public class Test1 {

    public static void main(String[] args) {
        new Test1();
    }

    public Test1() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFileChooser fc = new JFileChooser();
                JCheckBox cb = new JCheckBox("Open file after saving");

                if (System.getProperty("os.name").startsWith("Windows 7")) {

                    try {
                        JTextField filenameTextField = (JTextField) getField("filenameTextField", fc.getUI());
                        JComboBox filterComboBox = (JComboBox) getField("filterComboBox", fc.getUI());

                        System.out.println(filenameTextField);
                        System.out.println(filterComboBox);

                        Container parent = filenameTextField.getParent();

                        parent.setLayout(new GridBagLayout());
                        parent.removeAll();
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.weightx = 1;
                        gbc.insets = new Insets(2, 2, 4, 2);

                        parent.add(filenameTextField, gbc); // file name field...

                        gbc.gridx++;
                        gbc.weightx = 0;
                        parent.add(cb, gbc); // Check box

                        gbc.gridx = 0;
                        gbc.gridy++;
                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                        parent.add(filterComboBox, gbc); // File types                        
                    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                } else if (System.getProperty("os.name").startsWith("Mac OS X")) {

                    try {
                        JComboBox filterComboBox = (JComboBox) getField("filterComboBox", fc.getUI());
                        Container parent = filterComboBox.getParent();
                        parent.add(cb);
                    } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }

                fc.showOpenDialog(null);
            }

        });
    }

    private Object getField(String name, Object parent) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class aClass = parent.getClass();
        Field field = aClass.getDeclaredField(name);
        field.setAccessible(true);
        return field.get(parent);
    }

}