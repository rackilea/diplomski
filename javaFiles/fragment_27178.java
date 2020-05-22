int x1 = Gdx.input.getX();
int y1 = Gdx.input.getY();
Vector3 input = new Vector3(x1, y1, 0);
cam.unproject(input);
//Now you can use input.x and input.y, as opposed to x1 and y1, to determine if the moving
//sprite has been clicked
if(sprite.getBoundingRectange().contains(input.x, input.y)) {
    //Do whatever you want to do with the sprite when clicked
}