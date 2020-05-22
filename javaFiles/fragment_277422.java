public class JPasswordFieldTest {

    private JPanel panel;

    public JPasswordFieldTest() {
        panel = new JPanel();
        //set horizontal gap
        ((FlowLayout) panel.getLayout()).setHgap(2);

        panel.add(new JLabel("Enter pin :"));
        JPasswordField passwordField = new JPasswordField(4);
        PlainDocument document = (PlainDocument) passwordField.getDocument();
        document.setDocumentFilter(new DocumentFilter() {

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= 4) {
                    super.replace(fb, offset, length, text, attrs); //To change body of generated methods, choose Tools | Templates.
                }
            }

        });
        panel.add(passwordField);
        JButton button = new JButton("OK");
        panel.add(button);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI("Password Example");
            }
        });

    }

    private static void createAndShowGUI(String str) {
        JFrame frame = new JFrame(str);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPasswordFieldTest test = new JPasswordFieldTest();
        frame.add(test.panel);
        frame.pack();
        frame.setVisible(true);
    }

}