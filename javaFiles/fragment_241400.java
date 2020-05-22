public void changeBackground(Graphics g) throws SlickException{
    Thread.sleep(500);
    g.setBackground(new org.newdawn.slick.Color(0, 255, 0);
    Thread.Sleep(500);
    g.setBackground(new org.newdawn.slick.Color(255, 0, 0);
    changeBackground(g); // you're calling this funct again!  BAD
}