@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int x = 0; x < getWidth(); x++){
        for(int y = 0; y < getHeight(); y++){
            int col = (int)(Math.round(Math.random()*100)%50);
            if(Math.random() > 0.5){
                col = 255 - col;
            }
            g.setColor(new Color(col, col, col);
            g.fillRect(x, y, 1, 1);
        }
    }
}