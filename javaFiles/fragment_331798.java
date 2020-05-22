int rows = 3, cols = 3;
BufferedImage[][] pieces = new BufferedImage[rows][cols];

int imageWidth = image.getWidth();
int imageHeight = image.getHeight();
int pieceWidth = imageWidth/cols;
int pieceHeight = imageHeight/rows;

for (int i = 0; i < rows; i++)
{
    for (int j = 0; j < cols; j++)
    {
        pieces[i][j] = image.getSubimage(j*pieceWidth, i*pieceHeight, pieceWidth, pieceHeight);
    }
}