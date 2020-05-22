myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (myControl != null) {
            myControl.myButtonAction(e);
        }
    }
});