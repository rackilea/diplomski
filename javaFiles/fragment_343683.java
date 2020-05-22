public class DeselectOnClickListener extends MouseAdapter
{   
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        clearselection(e);      
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        clearselection(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        clearselection(e);
    }

    public void clearselection (MouseEvent e){      
        if (e.getComponent() instanceof JTable){
            Point pClicked = e.getPoint();
            JTable table = (JTable) e.getSource();
            int index = table.rowAtPoint(pClicked);
            if (index == -1){
                table.clearSelection();
            }

        } else if (e.getComponent() instanceof JList){
            Point pClicked = e.getPoint();
            JList<?> list = (JList<?>) e.getSource();
            int index = list.locationToIndex(pClicked);
            Rectangle rec = list.getCellBounds(index, index);
            if (rec==null || !rec.contains(pClicked)){
                list.clearSelection();
            }
        }
    }
}