public void setUpSportColumn(JTable table, TableColumn sportColumn) {
    //Set up the editor for the sport cells.
    ArrayList<String> listSomeString = new ArrayList<String>();        
    listSomeString.add("Snowboarding");
    listSomeString.add("Rowing");
    listSomeString.add("Knitting");
    listSomeString.add("Speed reading");
    listSomeString.add("Pool");
    listSomeString.add("None of the above");
    Java2sAutoComboBox comboBox = new Java2sAutoComboBox(listSomeString);
    comboBox.setDataList(listSomeString);
    sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
    //Set up tool tips for the sport cells.
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    renderer.setToolTipText("Click for combo box");
    sportColumn.setCellRenderer(renderer);
}