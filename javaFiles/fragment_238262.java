public class ActionCellRenderer extends DefaultTableCellRenderer{

   public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus,int row, int column){

      //get the label
      JLabel label = (JLabel)super.getTableCellRendererComponent(table, value,isSelected, hasFocus,row, column);

      //do whatever you want with the label

      return label;
   }
}