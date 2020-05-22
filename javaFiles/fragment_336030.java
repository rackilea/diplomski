import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestJFileChooser {

    public TestJFileChooser() {

    }

    protected void initUI() {
        JFrame frame = new JFrame(TestJFileChooser.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(new File(chooser.getCurrentDirectory(), "save.dat"));
                final JTextField textField = getTexField(chooser);
                if (textField != null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            String text = textField.getText();
                            if (text != null) {
                                int index = text.lastIndexOf('.');
                                if (index > -1) {
                                    textField.setSelectionStart(0);
                                    textField.setSelectionEnd(index);
                                }
                            }
                        }
                    });
                }
                chooser.showSaveDialog(button);
            }

            private JTextField getTexField(Container container) {
                for (int i = 0; i < container.getComponentCount(); i++) {
                    Component child = container.getComponent(i);
                    if (child instanceof JTextField) {
                        return (JTextField) child;
                    } else if (child instanceof Container) {
                        JTextField field = getTexField((Container) child);
                        if (field != null) {
                            return field;
                        }
                    }
                }
                return null;
            }
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestJFileChooser fc = new TestJFileChooser();
                fc.initUI();
            }
        });
    }
}