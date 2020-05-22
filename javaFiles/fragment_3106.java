int imageWidth = bricks[0][0].getWidth(this),
    imageHeight = bricks[0][0].getHeight(this);

for (int i = 0; i < bricks.length; i++)
    for ( int j =0; j < bricks[0].length; j++)
        g.drawImage(bricks[i][j], i * imageWidth + 85, j * imageHeight + 30, this);