public void update(GameContainer container, int delta, Map map) {
    Input input = container.getInput();
    float dx = 0, dy = 0;
    // add to dx and dy instead of moving the player straight away.
    if (input.isKeyDown(Input.KEY_D)) dx += velX;
    if (input.isKeyDown(Input.KEY_A)) dx -= velX;
    if (input.isKeyDown(Input.KEY_W)) dy -= velY;
    if (input.isKeyDown(Input.KEY_S)) dy += velY;
    // here we check the collisions, you can fiddle with this if statement and it'll behave differently.
    if(dx != 0 || dy != 0){
        if(map.checkCollision(x+dx,y+y){
           x+=dx;
           y+=dy;
        }
    }
}