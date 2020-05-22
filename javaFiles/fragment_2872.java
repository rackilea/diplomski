@Override
public Component getTableCellRendererComponent(JTable table, Object obj,
        boolean isSelected, boolean hasFocus, int row, int column) {

    Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

    //add condition for desired cell
    if (row == 1 && column == 1)
        cell.setBackground(Color.YELLOW);

    return cell;
}