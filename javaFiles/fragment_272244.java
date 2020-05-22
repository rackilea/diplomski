ActionListener a = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            doButton1Stuff();
        }
        if (e.getSource() == button2) {
            doButton2Stuff();
        }
        ...
    }
}
button1.addActionListener(a);
button2.addActionListener(a);