public class OvertimeSumListener implements DocumentListener {
    private JTextField[] otFields;
    private JTextField total;

    public OvertimeSumListener(JTextField[] otFields, JTextField total) {
        this.otFields = otFields;
        this.total = total;
    }

    public void calculateTotal() {
        double sum = 0;
        for (JTextField otField : otFields) {
            String text = otField.getText();
            try {
                sum += Double.parseDouble(text);
            } catch (NumberFormatException e) {
                // not a number - ignore
            }
        }
        total.setText(String.format("%.2f", sum));
    }

    public void insertUpdate(DocumentEvent e) {
        calculateTotal();
    }

    public void removeUpdate(DocumentEvent e) {
        calculateTotal();
    }

    public void changedUpdate(DocumentEvent e) {
        calculateTotal();
    }
}