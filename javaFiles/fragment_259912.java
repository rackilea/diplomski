buttons[1].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        clockSolitaireFrame.dispose();
        new ClockSolitaire(); 
        dialog.setVisible(false);
    }
});