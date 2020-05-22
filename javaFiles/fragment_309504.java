private void myButtonAction() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(frmMainwindow);
    if (result==JFileChooser.APPROVE_OPTION) {
        // do something with the chosen file ..
    }
}