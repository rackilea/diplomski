public void mousePressed(MouseEvent e)  {check(e);}
public void mouseReleased(MouseEvent e) {check(e);}

public void check(MouseEvent e) {
    if (e.isPopupTrigger()) { //if the event shows the menu
        jList.setSelectedIndex(jList.locationToIndex(e.getPoint())); //select the item
        jPopupMenu.show(jList, e.getX(), e.getY()); //and show the menu
    }
}