btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        NewRoundListener listener = new War();
        listener.newRound();
    }
});