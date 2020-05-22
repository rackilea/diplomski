DefaultTableModel aModel = new DefaultTableModel();
try (ResultSet rs = db.query("SELECT * FROM Students ")) {
    ResultSetMetaData rsmd = rs.getMetaData();
    for (int col = 0; col < rsmd.getColumnCount(); col++) {
        aModel.addColumn(rsmd.getColumnName(col + 1));
    }

    while (rs.next()) {
        Object[] value = new Object[rsmd.getColumnCount()];
        for (int col = 0; col < rsmd.getColumnCount(); col++) {
            value[col] = rs.getObject(col + 1);
        }
        aModel.addRow(value);
    }
} catch (SQLException ex) {
    Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
}
jTable2.setModel(model);