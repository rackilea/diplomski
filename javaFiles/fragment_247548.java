public void paint (final Graphics g){
    super.paint (g);
    g.drawRect(100, 100, 200, 200);
    if(closeDoors){
        g.fillRect(100, 100, 200, 200);
    }
}