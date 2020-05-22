import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private JLabel status;

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JTextArea ta = new JTextArea(10, 10);
                InputMap im = ta.getInputMap(JTextArea.WHEN_FOCUSED);
                ActionMap am = ta.getActionMap();

                Object key = im.get(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
                Action insertBreak = am.get(key);

                am.put(key, new MyNewOnEnterAction(insertBreak));

                status = new JLabel("...");

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(ta));
                frame.add(status, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void sendMessage(String message) {

    }

    public class MyNewOnEnterAction extends AbstractAction {

        private Action proxy;

        public MyNewOnEnterAction(Action proxy) {
            this.proxy = proxy;
        }

        public int getLineAtCaret(JTextComponent component) {
            int caretPosition = component.getCaretPosition();
            Element root = component.getDocument().getDefaultRootElement();

            return root.getElementIndex(caretPosition) + 1;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea ta = (JTextArea) e.getSource();
            int line = getLineAtCaret(ta);
            try {
                int startPos = ta.getLineStartOffset(line - 1);
                int endPos = ta.getLineEndOffset(line - 1);
                Document doc = ta.getDocument();

                String text = doc.getText(startPos, endPos - startPos);
                status.setText(text);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }

            proxy.actionPerformed(e);
        }

    }

}