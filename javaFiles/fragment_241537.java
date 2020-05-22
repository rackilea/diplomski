JButton btnCompute = new JButton("Compute");
btnCompute.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            double leftValue = Double.parseDouble(lhs.getText());
            double rightValue = Double.parseDouble(rhs.getText());
            // Do your stuff with it.
        }
        catch ( NumberFormatException ex ) {
            // Do stuff if the input is not a number.
        }
    }
}