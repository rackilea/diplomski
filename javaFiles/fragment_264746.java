public void mouseClicked(MouseEvent event){
    statusbar.setText(String.format("Clicked at %d,%d", event.getX(), event.getY()));
    System.out.println(String.format("Component clicked was " + findComponentAt(event.getX(), event.getY()).getBackground()));

    Component comp =  findComponentAt(event.getX(), event.getY());
    if (!(comp instanceof JLabel)) {
       return;   // if it's not a JLabel get out of this method
    }

    // it is a JLabel so cast it.

    JLabel temp = (JLabel) comp;

    // now you can use the JLabel