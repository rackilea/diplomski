public void paint (Graphics g){
    super.paint(g);    
    g.setColor(Color.BLACK);        
    Graphics2D gg = (Graphics2D) g.create();   // create new layer and cast to advanced Graphics2d
    gg.rotate(Math.toRadians(x), 90,90);       // rotate new layer at center position 90,90 around x degrees 
    gg.drawLine(90,90,0,0);                    // draw line to center position
    gg.dispose();                              // push new layer back
}