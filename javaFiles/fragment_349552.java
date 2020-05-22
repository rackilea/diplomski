public void actionPerformed(ActionEvent ae) {
    int i=0;
    for (Object o : mWidget) {
        if (o instanceof JTextField) { 
             retValue[i++] = ((JTextField)o).getText();
        } else if (o instanceof JComboBox) { 
             retValue[i++] = ((JComboBox)o).getSelectedItem(); 
        }
    }
}