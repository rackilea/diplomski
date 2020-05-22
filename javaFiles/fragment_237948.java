public static MouseInputAdapter mouseHandler = new MouseInputAdapter(){
    //internal JLabel displacement on mouse press for smooth dragging
    public int labelDisX;   
    //internal JLabel displacement on mouse press for smooth dragging
    public int labelDisY;                 
    public void mousePressed(MouseEvent e) {
        labelDisX = e.getX();
        labelDisY = e.getY();
        //move the card above all others
        e.getComponent().getParent().setComponentZOrder(e.getComponent(), 0); 
        //repaint so card moves above others
        e.getComponent().getParent().repaint();                               
    }
    public void mouseDragged (MouseEvent e) {
        JPanel panel = (JPanel) e.getComponent().getParent();
        //get preliminary new X coordinate
        int newX = e.getComponent().getX() + e.getX() - labelDisX; 
        //get preliminary new Y coordinate
        int newY = e.getComponent().getY() + e.getY() - labelDisY;  
        //here we check that the card is not
        //being moved off the panel. If the
        //user does try and do this then
        //make the new coordinates such that
        //the card is bounded by the panel's
        //edges [extra credit]
        if(newX > panel.getWidth() - CARD_WIDTH) {
            newX = panel.getWidth() - CARD_WIDTH;                             
        }                                                                     
        if(newY > panel.getHeight() - CARD_HEIGHT) {                          
            newY = panel.getHeight() - CARD_HEIGHT;                           
        }                                                                     
        if(newX < 0) { newX = 0; }                                            
        if(newY < 0) { newY = 0; }
        e.getComponent().setLocation(newX, newY);
    }
};