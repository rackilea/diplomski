@Override
public void paint(Graphics g){
    super.paint(g); // Call it's parent for proper rendering.
    for (int i = 0; i<wallArray.length; i++)
        for (int j = 0; j<wallArray[0].length; j++){
            //do something for every field in the array
            //i.e. g.setColor(Color.getColor(wallArray[i][j], 50, 50)); 
            //g.drawLine(i,j,i,j);
    }
    player.display(g);
    enemy.display(g);
}