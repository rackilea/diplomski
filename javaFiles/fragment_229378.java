import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
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
            setBorder(new EmptyBorder(20, 20, 20, 20));
            JTextField field = new JTextField(10);
            LimitedRangeDocumentFilter filter = new LimitedRangeDocumentFilter(1, 1000);
            filter.setLimitedRangeDocumentFilterListener(new LimitedRangeDocumentFilterListener() {
                @Override
                public void updateWouldBeInvalid(LimitedRangeDocumentFilter filter, String text) {
                    JOptionPane.showMessageDialog(TestPane.this, 
                            text + " is not within " + filter.getMin() + "-" + filter.getMax() + " range",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
            ((AbstractDocument)field.getDocument()).setDocumentFilter(filter);
            add(field);
        }

    }

    public interface LimitedRangeDocumentFilterListener {
        public void updateWouldBeInvalid(LimitedRangeDocumentFilter filter, String text);
    }

    public class LimitedRangeDocumentFilter extends DocumentFilter {

        private int min;
        private int max;

        private LimitedRangeDocumentFilterListener listener;

        public LimitedRangeDocumentFilter(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public void setLimitedRangeDocumentFilterListener(LimitedRangeDocumentFilterListener listener) {
            this.listener = listener;
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset,
                String string, AttributeSet attr)
                throws BadLocationException {

            StringBuilder sb = new StringBuilder(string);
            for (int i = sb.length() - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                if (!Character.isDigit(ch)) {
                    sb.deleteCharAt(i);
                }
            }

            StringBuilder master = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
            master.insert(offset, sb.toString());
            if (wouldBeValid(master.toString())) {
                super.insertString(fb, offset, sb.toString(), attr);
            } else if (listener != null) {
                listener.updateWouldBeInvalid(this, master.toString());
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb,
                int offset, int length, String string, AttributeSet attr) throws BadLocationException {
            if (length > 0) {
                fb.remove(offset, length);
            }
            insertString(fb, offset, string, attr);
        }

        protected boolean wouldBeValid(String text) {
            boolean wouldBeValid = false;
            try {
                int value = Integer.parseInt(text);
                if (value >= min && value <= max) {
                    wouldBeValid = true;
                }
            } catch (NumberFormatException exp) {
            }
            return wouldBeValid;
        }
    }

}