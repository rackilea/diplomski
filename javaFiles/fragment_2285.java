public class NumRange extends JFrame {

    public static void main(String[] args) {

        new NumRange();
    }

    NumRange() {

        final int MIN = 0;
        final int MAX = 100;

        JTextField textField = new JTextField();
        textField.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                int num;
                try {
                    num = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    return false;
                }
                if (num <= MAX && num >= MIN)
                    return true;
                return false;
            }
        });

        getContentPane().add(textField);
        getContentPane().add(new JTextField(), BorderLayout.PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}