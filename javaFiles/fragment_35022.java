public class Main extends JFrame {

    JTextField textFieldKwotaWplacona, textFieldOprocentowanie;

    Main() {

        setTitle("Program do liczenia procentu składanego");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textFieldKwotaWplacona = new JTextField("Ilość pieniędzy wpłaconych");
        textFieldKwotaWplacona.setForeground(Color.decode("0x8C8C8C"));
        textFieldKwotaWplacona.addFocusListener(new FieldFocusListener(textFieldKwotaWplacona));
        add(textFieldKwotaWplacona);

        textFieldOprocentowanie = new JTextField("Oprocentowanie");
        textFieldOprocentowanie.setForeground(Color.decode("0x8C8C8C"));
        textFieldOprocentowanie.addFocusListener(new FieldFocusListener(textFieldOprocentowanie));
        add(textFieldOprocentowanie);

        JRadioButton btn = new JRadioButton("text");
        add(btn);

        pack();
        btn.requestFocusInWindow();
    }

    private class FieldFocusListener extends FocusAdapter {

        private JTextField field;

        FieldFocusListener(JTextField field) {

            this.field = field;
        }

        @Override
        public void focusGained(FocusEvent e) {

            if (field.getForeground() != Color.BLACK) {
                field.setText("");
                field.setForeground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {

        Main a = new Main();
        a.setVisible(true);
    }
}