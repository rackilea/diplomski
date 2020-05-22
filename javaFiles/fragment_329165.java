public void mouseDragged(MouseEvent e) {
    System.out.println("Drag = " + e);
    MouseX = e.getX() + 5; // <- note here
    if (MouseX < 0) {
        MouseX = 0;
    }
    MouseY = e.getY() - 15; // <- note here
    if (MouseY < 0) {
        MouseY = 0;
    }
    // move label to the new location

    theLabel.setLocation(MouseX, MouseY);

    theLabel.setForeground(Color.black);
    String coordtextClick = MouseX + " , " + MouseY;
    theLabel.setText(coordtextClick);
}// end mouseDragged()

public void mouseMoved(MouseEvent e) {
    System.out.println("Move = " + e);
    theLabel.setForeground(Color.red);
    MouseX = e.getX() + 5; // <- note here
    if (MouseX < 0) {
        MouseX = 0;
    }
    MouseY = e.getY() - 15; // <- note here
    if (MouseY < 0) {
        MouseY = 0;
    }
    String coordtext = MouseX + " , " + MouseY;
    theLabel.setLocation(MouseX, MouseY);
    theLabel.setText(coordtext);
}//