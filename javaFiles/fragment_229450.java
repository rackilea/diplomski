start.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // If the button is pressed, delete text field and replace with new content

        PowerBall roll = new PowerBall();
        roll.randomize();
        System.out.println(roll.toString());
        roll.calculate();
        roll.displayBalance();
        roll.displayWinnings();

        setButtonPressed(true);
        outputText.setText("");
        outputText.setText(outText);
    }
});