public Rectangle findRectangle(int x, int y){
    // this could be optimized. You could keep a separate collection where
    // you remove rectangles from, once your cursor is below that rectangle
    for(Rectangle rectangle : mazeRectangles){ 
        if(!rectangle.contains(x, y)){
            return rectangle;
        }
    }
    //find the width of the `Rectangle`
    int xD = 0;
    while(x+xD < width && isMazeColour(image.getRGB(x+xD+1, y))){
        xD++;
    }

    int yD = 0; //todo: find height of rect..

    Rectangle toReturn = new Rectangle(x, y, xD, yD);
    mazeRectangles.add(toReturn);
    return toReturn;
}