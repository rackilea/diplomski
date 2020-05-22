public class TestHighlight {

    public static void main(String[] args) {
        new TestHighlight();
    }

    public TestHighlight() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextPane textPane = new JTextPane(new DefaultStyledDocument());
                ((AbstractDocument) textPane.getDocument()).setDocumentFilter(new HighlightDocumentFilter(textPane));
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(textPane));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class HighlightDocumentFilter extends DocumentFilter {

        private DefaultHighlightPainter highlightPainter = new DefaultHighlightPainter(Color.YELLOW);
        private JTextPane textPane;
        private SimpleAttributeSet background;

        public HighlightDocumentFilter(JTextPane textPane) {
            this.textPane = textPane;
            background = new SimpleAttributeSet();
            StyleConstants.setBackground(background, Color.RED);
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            System.out.println("insert");
            super.insertString(fb, offset, text, attr);
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            System.out.println("remove");
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

            String match = "test";

            super.replace(fb, offset, length, text, attrs);

            int startIndex = offset - match.length();
            if (startIndex >= 0) {

                String last = fb.getDocument().getText(startIndex, match.length()).trim();
                System.out.println(last);
                if (last.equalsIgnoreCase(match)) {

                    textPane.getHighlighter().addHighlight(startIndex, startIndex + match.length(), highlightPainter);

                }

            }
        }

    }

}