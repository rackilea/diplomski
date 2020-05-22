public class ColorRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)  {
       // get the DefaultCellRenderer to give you the basic component
       Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
       // apply your rules
       if(table.isRowSelected(row) && table.isColumnSelected(col))
          c.setBackground(Color.GREEN);
       else{    
           c.setBackground(table.getBackground());
       }

       return c;
    }
}