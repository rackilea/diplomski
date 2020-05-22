for (int i=1; i<10; i++){
    squareX = posX + (diffX/10)*i;
    squareY = posY + (diffY/10)*i;
    Square square = new Square(squareX,squareY,200);         
    square.draw(w);
}