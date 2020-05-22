JLabel label = new JLabel();
JButton button = new JButton("Click me");
button.addActionListener((ActionEvent e) -> {
    // This event listener is run when the button is clicked.
    // We don't need to loop while waiting.
    label.setText("Button was clicked");
});