@Override
public void init(GameContainer gc) throws SlickException {
    land = new Image("bg.jpg");        
}

@Override
public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
    g.drawImage(land, 0, 0);
}