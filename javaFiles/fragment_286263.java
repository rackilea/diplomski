public JTable menuTableMethod(String []title, String [][]data){
    //menuTable = new JTable(data, title);
    defaultModel.setDataVector(data, title);

    menuTable.setPreferredScrollableViewportSize(new Dimension(380, 250));
    //menuTable.setBackground(Color.lightGray);
    menuTable.setFillsViewportHeight(true);
    menuTable.updateUI();
    menuTable.validate();
    //JOptionPane.showMessageDialog(null, "Table update ! ");

    return menuTable;
}