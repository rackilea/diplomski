Image title = null;

    public static void main(String[] args) {

}

@Override
public void init(GameContainer Gc, StateBasedGame Sbg)
        throws SlickException {

    /**
     * Images
     */

    title = new Image("gfx/main_menu/title/new_title.png");
}

@Override
public void render(GameContainer Gc, StateBasedGame Sbg, Graphics G)
        throws SlickException {

    /**
     * Background
     */

    G.setColor(Color.white);
    G.fillRect(0, 0, w*s, h*s);

    /**
     * Images
     */

    title.draw(titleY*s,titleX*s);
}