int selectedOption = JOptionPane.YES_OPTION; // by default
while (selectedOption == JOptionPane.YES_OPTION) {
    // do your stuff
    selectedOption = 
        JOptionPane.showConfirmDialog(null,"Continue?","Choose",JOptionPane.YES_NO_OPTION);
}