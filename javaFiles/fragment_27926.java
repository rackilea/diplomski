// in the isSelected block of the propertyChangeListener:
JComponent current = (JComponent) evt.getSource();
slaveTable.setRowSelectionInterval(getNum(), getNum());
// get the cellRect of the selected cell
Rectangle cellRect = slaveTable.getCellRect(getNum(), 0, false);
// get the bounds of the selected panel
Rectangle panelRect = current.getBounds();
// get the visible rect of the selected panel's parent
Rectangle parentVisibleRect = ((JComponent) current.getParent()).getVisibleRect(); 
// the diff above the current (to the parent's visible rect)
int aboveCurrent = panelRect.y - parentVisibleRect.y;
// translate the cell rect 
cellRect.y = Math.max(cellRect.y - aboveCurrent, 0);
// adjust size to slaveTable's visible height
cellRect.height = slaveTable.getVisibleRect().height;
slaveTable.scrollRectToVisible(cellRect);