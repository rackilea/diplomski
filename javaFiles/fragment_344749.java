public void paint(Graphics g){
    System.out.println("paint");
    if (Lands.size() > 0) {
        g.setColor(new Color(25,150,50));
        g.fillRect(Lands.get(0).xPos,Lands.get(0).yPos, Lands.get(0).Width, Lands.get(0).Height);
    }
}