private void LoadSupplierTable() {
    clearTable((javax.swing.table.DefaultTableModel) tblSupp.getModel());
    javax.swing.table.DefaultTableModel dtSupp = (javax.swing.table.DefaultTableModel) tblSupp.getModel();

    try {
        ResultSet resO = null;
        String sqo = "select id,name from supplier";
        Connection coo = DataBaseConnection.getDbConnection();
        PreparedStatement pso = coo.prepareStatement(sqo);
        resO = pso.executeQuery();
        while (resO.next()) {
            Vector ver = new Vector();
            ver.add(resO.getInt("id"));
            ver.add(resO.getString("name"));
            dtSupp.addRow(ver);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}