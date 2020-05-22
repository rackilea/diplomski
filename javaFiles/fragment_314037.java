@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);  
    for ( int i = 0; i < numberOfTiles; i++ ){
        g.setColor(colorOfCurrentTile);
        g.fillRect(left, top, width, height);
    }
}