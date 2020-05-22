public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){  
    Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);  

    if(rowIndex % 2 == 0) {  
       componenet.setBackground(Color.RED);  
    } else {
       componenet.setBackground(Color.GREEN);
    }
    return componenet;
}