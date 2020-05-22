void mousePressed(MouseEvent ev) {
     // get the row/column from mouse location
     int column = table.columnAtPoint(ev.getPoint());
     int row = table.rowAtPoint(ev.getPoint());
     // set some kind of marker, f.i. as client property
     table.putClientProperty("hitColumn", column);
     table.putClientProperty("hitRow", row);
     // get the rectangle for repainting 
     Rectangle cell = table.getCellRect(column, row, false);
     table.repaint(cell);
 }

 void mouseReleased(MouseEvent ev) {
     // similar to reset the marker
     ....
     table.repaint(cell);
 }

 // custom renderer extends DefaultTableCellRenderer

 JComponent getTableCellRendererComponent(..., row, column ...) {
     Integer hitColumn = table.getClientProperty("hitColumn");
     Integer hitRow = ....
     if (hitColumn != null && column == hitColumn && hitRow ....) {
        setBackground(hitColor);
     } else {
         // force super to handle the background 
         setBackground(null);
     }
     return super.getTableCellRendererComponent(....);
 }