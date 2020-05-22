if(Gdx.input.isKeyPressed(Keys.D){
    float requestedX, requestedY;
    //calculate the requested coordinates
    Rectangle newPlayerPositionRectangle = new Rectangle(requestedX, requestedY, player.getWidth(), player.getHeight());
    if (newPlayerPositionRectangle.overlaps(map) {
        //move the player
    } else {
        //move the player only to the edge of the map and stop there
    }
}