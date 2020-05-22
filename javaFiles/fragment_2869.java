public class CellRenderer extends DefaultTableCellRenderer {

@Override
public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
    Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

    if (isSelected)
        cell.setBackground(Color.YELLOW);
    else if (column == 0)
        cell.setBackground(new Color(0xDDDDD));
    else 
        cell.setBackground(new Color(0xFFFFFF));

    return cell;
}