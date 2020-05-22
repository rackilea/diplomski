public void draw(Graphics2D g2d){
    for(int y = 0; y < mapArray.length; y++){
        for(int x = 0; x < mapArray[y].length; x++){ //you want to use y here not 0
            if(mapArray[y][x] == 1){                 //first box is outer array second is inner one
                ImageIcon ic = new ImageIcon("/Textures/stone.jpg");
                g2d.drawImage(ic.getImage(), x, y, null);
            } else if(mapArray[y][x] == 0){
                ImageIcon ic = new ImageIcon("/Textures/water.jpg");
                g2d.drawImage(ic.getImage(), x, y, null);
            }
        }
    }
}