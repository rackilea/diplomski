try {
    int size = Integer.parseInt(hardDisk.getText());
    s1.setHardDisk(size);
    dsdisplay2.setText("The Hard Disk size for your PC has been set to: " + s1.getMemory());
} catch (NumberFormatException e) {
    dsdisplay2.setText("ERROR: You must enter a positive number in order to set the memory\n");
}