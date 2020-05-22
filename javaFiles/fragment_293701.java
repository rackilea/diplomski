public class DigitPanel extends JPanel {

    private JLabel label = new JLabel(String.valueOf(digit));

    public DigitPanel() {
        label = new JLabel(String.valueOf(0));
        label.setFont(new Font("Tahoma", Font.BOLD, 72));
        label.setForeground(Color.WHITE);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(80, 80));
        this.setBackground(Color.BLACK);
        this.add(label);
    }

    public final char getDigit() {
        return label.getText().charAt(0);
    }

    public void setDigit(char digit) {
        label.setText(Character.toString(digit);
    }
}