import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class Application {

    private static final String PREFIX = "Your Input>";

    private static final int prefixLength = PREFIX.length();

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame rootFrame = new JFrame();
        JTextField textField = new JTextField(new PromptDocument(), PREFIX, 20);

        rootFrame.add(textField);
        rootFrame.pack();
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootFrame.setVisible(true);
    }

    private static class PromptDocument extends DefaultStyledDocument {

        private static final long serialVersionUID = 1L;

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            if (offs > prefixLength - 1) {
                int buffer = offs - prefixLength;
                if (buffer < 0) {
                    len = buffer;
                }
                super.remove(offs, len);    
            }
        }
    }
}