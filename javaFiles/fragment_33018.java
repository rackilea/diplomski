Square[][] squares = new Square[width][height];
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            squares[i][j] = new Square();
            frame.add(squares[i][j]);
        }
    }