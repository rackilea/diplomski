import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;

public class Test {

    private JFrame frame;
    private JTextArea ta;

    protected void initUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta = new JTextArea();
        DefaultCaret caret = (DefaultCaret) ta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        frame.add(new JScrollPane(ta));
        frame.setSize(400, 200);
        frame.setVisible(true);
        new UpdateText().execute();
    }

    class UpdateText extends SwingWorker<String, String> {

        @Override
        public String doInBackground() {
            for (int i = 0; i < 1000; i++) {
                publish("Hello-" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public void process(List<String> chunks) {
            for (String s : chunks) {
                if (ta.getDocument().getLength() > 0) {
                    ta.append("\n");
                }
                ta.append(s);
            }
            try {
                ta.setCaretPosition(ta.getLineStartOffset(ta.getLineCount() - 1));
            } catch (BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void done() {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().initUI();
            }
        });
    }

}