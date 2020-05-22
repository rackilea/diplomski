public void actionPerformed(ActionEvent e) {
    JComboBox comboBox = (JComboBox)e.getSource();
    String selectedRoute = (String)comboBox.getSelectedItem();
    RootSelection r1=new RootSelection();

    //Settings object
    Settings mySettings = new Settings();
    mySettings.setRootName(selectedRoute);
}