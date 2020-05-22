public class TestField {

    public static void main(String[] args) {
        new TestField();
    }

    public TestField() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class NumericDocumentFilter extends DocumentFilter {

        private int maxChars;

        public NumericDocumentFilter(int maxChars) {
            this.maxChars = maxChars;
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset,
                String text, AttributeSet attr)
                throws BadLocationException {

            StringBuilder buffer = new StringBuilder(text);
            for (int i = buffer.length() - 1; i >= 0; i--) {
                char ch = buffer.charAt(i);
                if (!Character.isDigit(ch)) {
                    buffer.deleteCharAt(i);
                }
            }

            text = buffer.toString();
            if (fb.getDocument().getLength() + text.length() > maxChars) {
                int remaining = maxChars - fb.getDocument().getLength();
                text = text.substring(0, remaining);
            }

            if (text.length() > 0) {
                super.insertString(fb, offset, text, attr);
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
    }

    public class TestPane extends JPanel {

        private JTextField field;

        public TestPane() {

            setLayout(new GridBagLayout());

            field = new JTextField(4);
            ((AbstractDocument) field.getDocument()).setDocumentFilter(new NumericDocumentFilter(4));
            add(field);
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(field.getText());
                }
            });
        }
    }
}