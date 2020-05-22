private void addRestartButton() {
    String buttonText = "New Game?";
    restartButton = new JButton(buttonText);
    Font font = new Font("Helvetica", Font.BOLD, size);
    restartButton.setFont(font);

    setLayout(null);
    restartButton.setBounds(x,y,w,z);
    add(restartButton);

    restartButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            restart();
        }
    });  

    setButtonVisibility(false);
}