private Rectangle leftSide;
private Rectangle rightSide;

public void resize (int width, int height) {
    //...

    leftSide = new Rectangle(0, 0, width/2, height);
    rightSide = new Rectangle(width/2, 0, width/2, height);
}

public void render() {

    //...

    spriteBatch.begin();
    //draw background

    spriteBatch.flush();
    ScissorStack.pushScissors(leftSide);
    //draw left side stuff that is cropped
    spriteBatch.flush();
    ScissorStack.popScissors();
    ScissorStack.pushScissors(rightSide);
    //draw right side stuff that is cropped
    spriteBatch.flush();
    ScissorStack.popScissors();
    //draw any other stuff that is not cropped on top of everything else
    spriteBatch.end();
}