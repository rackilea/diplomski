private class MouseHandler extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent event) {

        statusBar.setText( String.format( "Pressed at [%d, %d]",
            event.getX() , event.getY() ) );
        int x = event.getX();
        int y = event.getY();

        mapObject.updateDockOrShip(x, y,text); //updates selected icon on screen
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        statusBar.setText( String.format( "Released at [%d, %d]",
            event.getX() , event.getY() ) );
        int x = event.getX();
        int y = event.getY();

        /*this is the troubleMaker, if i delete this line all "clicks"
          work everywhere on my JPanel. but if i leave it in, 
          clicks work in some areas of JPanel, and other legitimate clicks
          are recognized as mouseReleased in different area of JPanel
        */

        mapbject.checkDocks(x,y,tempint); //TROUBLE

    }

    // since this extends MouseAdapter, all the other methods are not needed
}