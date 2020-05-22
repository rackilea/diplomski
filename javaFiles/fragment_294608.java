ResultSet results = aJBDCStatement.executeQuery(
        "Select columnName FROM tableName");
DefaultComboBoxModel model = new DefaultComboBoxModel();
while (result.next()) {
    model.addElement(results.getString(1));
}
JComboBox comboBox = new JComboBox(model);