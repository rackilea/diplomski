import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComboBoxEditor;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
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

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            final JComboBox<String> cb = new JComboBox<>(new String[]{"Apples", "Bananas", "Pears"});
            cb.setEditable(true);
            SimpleComboBoxEditor editor = new SimpleComboBoxEditor();
            InputMap im = editor.getInputMap();
            ActionMap am = editor.getActionMap();
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
            am.put("enter", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!cb.isPopupVisible()) {
                        System.out.println("Editor did action");
                    }
                    cb.hidePopup();
                }
            });
            cb.setEditor(editor);
            cb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Combobox did action");
                }
            });
            add(cb);
        }

        public class SimpleComboBoxEditor extends JTextField implements ComboBoxEditor {

            @Override
            public Component getEditorComponent() {
                return this;
            }

            @Override
            public void setItem(Object anObject) {
                if (anObject != null) {
                    setText(anObject.toString());
                } else {
                    setText(null);
                }
            }

            @Override
            public Object getItem() {
                return getText();
            }

        }

    }

}