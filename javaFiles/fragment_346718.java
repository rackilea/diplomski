@override
public void actionPerformed(ActionEvent e) {
    JComboBox comboBox = (JComboBox)e.getSource();
    String selectedRoute = (String)comboBox.getSelectedItem();
    DBaccess dbAccess = new DBaccess();
    dbAccess.setRoute(selectedRoute);
    dbAccess.setVisible(true);
}