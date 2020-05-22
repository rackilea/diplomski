public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){  
Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);  

if(getValueAt(rowIndex, columnIndex).toString().equals("Red")) {  
   componenet.setBackground(Color.RED);  
} else if(getValueAt(rowIndex, columnIndex).toString().equals("Green")) {
   componenet.setBackground(Color.GREEN);
}
return componenet;
}