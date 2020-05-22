public void initStatesList(GameContainer gc) throws SlickException {
    this.getState(splash).init(gc, this);
    this.getState(menu).init(gc, this);
    this.getState(play).init(gc, this);

    this.enterState(menu);
}