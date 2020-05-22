boolean isBlank = true;

public void render(SpriteBatch batch){

    if(isBlank)
    batch.draw(BlankTile,xCoord,yCoord);
    else
    batch.draw(RedTile,xCoord,yCoord);

}