String[] header = { "ID", "Name", "Department" };

    String[][] datas = { { "0001", "Onur", "Java Developer" }, { "0002", "Umut", "Musical Ens" },
            { "0003", "Eymen", "Just Reader" }, { "0004", "Mustafa", "Worker" } };

    boolean isSelected = false;
    boolean hasFocus = false;

    JTable table = new JTable(datas, header);
    int rows = table.getRowCount();
    int cols = table.getColumnCount();
    Object color = (Color) Color.CYAN;
    table.setOpaque(false);
    table.setFillsViewportHeight(true);
    table.setCellSelectionEnabled(true);
    table.setBounds(30, 40, 200, 300);

    if (table.isCellSelected(rows, cols)) {
        isSelected = true;
    }
    Component comp = getTableCellRendererComponent(table, color, isSelected, hasFocus, rows, cols);
    if (rows == 1 && cols == 1)
        comp.setBackground(new java.awt.Color(0, 0, 255));
    JScrollPane pane = new JScrollPane(table);
    getContentPane().add(pane);

}

@Override
public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus,
        int row, int column) {
    Color newColor = (Color) color;
    table.setBackground(newColor);

    if (isSelected) {

        table.setBackground(Color.CYAN);
    } else {

        table.getSelectionBackground();
    }
    // Discussed in the following section
    return null;
}