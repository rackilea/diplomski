int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Do you wanna close the window?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
if (selectedOption == JOptionPane.YES_OPTION) {
    window.dispose();
}