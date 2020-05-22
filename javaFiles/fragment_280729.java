public Color randomColor() {

    Random rand = new Random();

    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);

    return randomColor;
}

newPiece = new Piece(this, randomPiece(), randomColor());.