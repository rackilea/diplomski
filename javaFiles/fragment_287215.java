public class MouseEventDemo implements MouseListener {
    //where initialization occurs:
    //Register for mouse events on blankArea and the panel.
    blankArea.addMouseListener(this);
    addMouseListener(this);
...


public void mouseClicked(MouseEvent e) {
   System.out.println ("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")", e);
}