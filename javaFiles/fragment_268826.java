/**
 * @Overide paint method was a thing in AWT.
 * In Swing you must override paintComponent (and call super.paintComponent())
 * in order to respect the paint chain.
 * 
 */
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (getParent() != null) { //Paint according to parent
        Graphics g2 = (Graphics2D) g;
        //Calculations
        int posX = Math.round(getParent().getWidth() / 100) * 20;
        int posY = Math.round(getParent().getHeight() / 100) * 20;
        int Width = Math.round(getParent().getWidth() / 100) * 80;
        int Height = Math.round(getParent().getHeight() / 100) * 80;
        g2.drawOval(posX, posY, Width, Height);
    }
}