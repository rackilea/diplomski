public void FillSelectSerie(String fabricante) {

    DefaultComboBoxModel box;
    box = new DefaultComboBoxModel();
    box.removeAllElements();

    try {
        String[] sql = {"TABLE"};
        rs = con.getMetaData().getTables(null, fabricante, "%", sql);
        box.addElement("-");

        while (rs.next()) {
            String tables = rs.getString(3);
            box.addElement(tables);
        }
        selectSerie.setModel(box);
    } catch (SQLException error) {
        //JOptionPane.showMessageDialog (null,error);
    }
}