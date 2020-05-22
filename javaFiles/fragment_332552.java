public class MyCellRenderer extends DefaultTableCellRenderer{
private int columNum = 0;

public MyCellRenderer(int columNum) {
    // TODO Auto-generated constructor stub
    this.columNum = columNum;
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
    // TODO Auto-generated method stub
    Object object = table.getValueAt(row, this.columNum);

    if(object.equals("yourValue")) {
        setBackground(Color.RED);
    }
    return this;
}