import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestCaret {

    public TestCaret() {
        JTextArea textArea = createTextArea();
        JComboBox cBox = createComboBox(textArea);

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(textArea));
        frame.add(cBox, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JComboBox createComboBox(final JTextArea textArea) {
        DefaultComboBoxModel<Integer> model  = new DefaultComboBoxModel<>();
        int lines = textArea.getLineCount();
        for (int i = 0; i < lines; i++) {
            model.addElement(i);
        }
        final JComboBox cBox = new JComboBox(model);
        cBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int index = (Integer)cBox.getSelectedItem();
                textArea.setCaretPosition(
                        textArea.getDocument().getDefaultRootElement().getElement(index).getStartOffset());
                textArea.requestFocusInWindow();
            }
        });
        return cBox;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea(10, 50);
        textArea.setMargin(new Insets(15, 15, 15, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        String text 
                = "0 Hello World\n" + 
                "1 Hello World\n" + 
                "2 Hello World\n" + 
                "3 Hello World\n" + 
                "4 Hello World\n" + 
                "5 Hello World\n" + 
                "6 Hello World\n" +
                "7 Hello World\n" + 
                "8 Hello World\n" + 
                "9 Hello World\n"; 
        textArea.setText(text);
        return textArea;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestCaret();
            }
        });
    }
}