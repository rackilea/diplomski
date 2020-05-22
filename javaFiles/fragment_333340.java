public class CustomCellRenderer extends JLabel implements TableCellRenderer{

    ...

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {

        if(column==this.columnPlace){
            // set Place
         setText(Integer.toString(row+1));
        }
        else{
         // set Points depending on competitorsCount and row
            setText(Integer.toString(points[competitorsCount-1][row]));
        }
        return this;
    }
}