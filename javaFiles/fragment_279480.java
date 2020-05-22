public void tick(){
    if ( Player.getPos() == 3)
        x += 10;
    if ( Player.getPos() == 2)
        x -= 10;
    if (Player.getPos() == 1)
        y -= 10;
    if (Player.getPos() == 0)
        y += 10;
}