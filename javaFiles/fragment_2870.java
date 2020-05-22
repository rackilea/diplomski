public class CellHighlighterRenderer extends DefaultTableCellRenderer {

@Override
public Component getTableCellRendererComponent(JTable table, Object obj,
        boolean isSelected, boolean hasFocus, int row, int column) {

    Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

    cell.setBackground(Color.YELLOW);

    return cell;
}