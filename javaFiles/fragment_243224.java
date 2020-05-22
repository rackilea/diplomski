public void actionPerformed(ActionEvent submitClicked) {
    Component frame = new JFrame();
    JOptionPane.showMessageDialog(frame , "You've Submitted the name " + nameInput.getText() + " which is allowed.");

    // You can store the value of whatever the user enters.
    String inputName = nameInput.getText();

    // And add the if statements:
    if(inputName.equals("John") {
        JOptionPane.showMessageDialog(frame, "Verified");
    }
}