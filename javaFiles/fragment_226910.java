public void actionPerformed(ActionEvent evt) {
    ...
    if (whateverIsLeft < 1) {
        JButton src = (JButton)evt.getSource();
        src.setVisible(false);
    }

    attriL.setText("You have " + whateverIsLeft + " attribute points left");
}