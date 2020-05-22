@Override
public void actionPerformed(ActionEvent event2) {

    txtArea.setText(event2.getActionCommand() + " Clicked");
    Object source = event2.getSource();

    if (source == b1 && input1.isSelected()) {
        System.exit(0);
    }
    if (source == b1 && input2.isSelected()) {

        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        System.exit(0);
    }
    if (event2.getSource() == b1 && input3.isSelected()) {
        System.exit(0);
    }
    if (event2.getSource() == b2) {
        System.exit(0);
    }
}