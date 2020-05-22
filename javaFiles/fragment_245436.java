@Override
public void mousePressed(MouseEvent e) {
        origin = new Point(e.getPoint());
}
//each time the user stops dragging set dragged to false
@Override
public void mouseReleased(MouseEvent arg0) {
     dragged = false;
}

@Override
public void mouseDragged(MouseEvent e) {

        dragged=true;
        if(((Component) e.getSource()).getParent().equals(myPanel)
                || e.getSource().equals(myPanel)){
          if (origin != null) {
            JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, myPanel);
            if (viewPort != null) {
                int deltaX = origin.x - e.getX();
                int deltaY = origin.y - e.getY();

                Rectangle view = viewPort.getViewRect();
                view.x += deltaX;
                view.y += deltaY;
                myPanel.scrollRectToVisible(view);
            }
        }
}
@Override
public void actionPerformed(ActionEvent e){

    //stuff do detect the button...
    //..in case there is more than one panel, if the component belong to myPanel and dragg is false 
    if(((Component) e.getSource()).getParent().equals(myPanel)&&  dragged==false ){
    //do stuff
    }
}