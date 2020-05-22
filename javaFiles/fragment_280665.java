import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFileChooser fc = new JFileChooser();
                List<JTextField> fields = findAll(JTextField.class, fc);
                if (fields.size() == 1) {
                    JTextField fieldNameField = fields.get(0);
                    Container parent = fieldNameField.getParent();
                    JCheckBox cb = new JCheckBox("Open file after saving");

                    JComboBox fileTypes = findAll(JComboBox.class, parent).get(0);

                    parent.setLayout(new GridBagLayout());
                    parent.removeAll();
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.weightx = 1;
                    gbc.insets = new Insets(2, 2, 4, 2);

                    parent.add(fieldNameField, gbc); // file name field...

                    gbc.gridx++;
                    gbc.weightx = 0;
                    parent.add(cb, gbc); // Check box

                    gbc.gridx = 0;
                    gbc.gridy++;
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    parent.add(fileTypes, gbc); // File types

                } else {
                    System.out.println("Found to many results?!");
                }

                fc.showOpenDialog(null);
            }
        });
    }

    public <T extends Component> List<T> findAll(Class<? extends T> aClass, Container parent) {
        List<T> matches = new ArrayList<>();

        for (Component child : parent.getComponents()) {
            if (aClass.isInstance(child)) {
                matches.add((T)child);
            }
            if (child instanceof Container) {
                matches.addAll(findAll(aClass, (Container)child));
            }
        }

        return matches;
    }

}