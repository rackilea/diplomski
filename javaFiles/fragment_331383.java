public void setMeasureValues(String S[], int length) {
    Vector comboBoxItems = new Vector();
    for (int i = 1; i < length; i++) {
        comboBoxItems.add(S[i]);
    }

    //  XMLtoExcelGUI call = new XMLtoExcelGUI(); // **** no!
     DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(comboBoxItems);

    // give XMLtoExcelGUI a public method that sets 
    // its own combo box's model
    gui.setComboModel(defaultComboBoxModel);



}