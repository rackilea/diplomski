public class LabelFrame extends JFrame {
    private static final int ROWS = 30;
    private static final int COLS = 80;
    private static final String HTTPS_SEARCH = "https:Search";

    // .....

    public LabelFrame() {
        // ....

        urlString = new JTextField(HTTPS_SEARCH, 30);

        //.....

        urlString.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField textField = (JTextField) e.getComponent();
                String text = textField.getText();
                if (text.equals(HTTPS_SEARCH)) {
                    textField.setText("");
                }
            }
        });