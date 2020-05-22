if(retVal == JFileChooser.APPROVE_OPTION) {
    String filePath = chooser.getSelectedFile().getPath();
    txfFileSelect.setText(filePath);
    try {
        // Some other code where the program was actually hanging
    } catch (IOException e) {
        e.printStackTrace();
    }
else {
    txfFileSelect.setText("Test");
}