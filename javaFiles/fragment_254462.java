public TableModel getDataFromDatabase()
{
    DefaultTableModel model = new DefaultTableModel(5, 5);
    model.setValueAt("Hard", 0, 0);
    model.setValueAt("Coded", 1, 1);
    model.setValueAt("Data", 2, 2);

    return model;
}