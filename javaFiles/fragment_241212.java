public void paintComponent(Graphics g){
    random=new Random();

    super.paintComponent(g);    

    for(int i=0; i<=4; i++){
        rX=random.nextInt(500);
        rY=random.nextInt(500);
        g.fillRect(rX,rY,20,20);
    }


    g.setColor(Color.red);
    g.fillOval(x,y,20,20);

}