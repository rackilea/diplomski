public class CalculatorActionHandler implements ActionListener {
    private StringBuilder expression = new StringBuilder(32);
    private Gui gui;

    public CalculatorActionHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String text = source.getText();
        if (text.equals("=")) {
            doMath math = new doMath();
            int result = math.doMath1(expression.toString());
            expession = new StringBuilder(32);
            // Update the UI
        } else {
            expession.append(text);
            // Update this value to the screen, maybe using a JLabel
        }
    }
}