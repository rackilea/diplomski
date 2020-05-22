Bitmap bitmap = someBitmap; //assign your bitmap here
int redColors = 0;
int greenColors = 0;
int blueColors = 0;
int pixelCount = 0;

for (int y = 0; y < bitmap.getHeight(); y++)
{
    for (int x = 0; x < bitmap.getWidth(); x++)
    {
        int c = bitmap.getPixel(x, y);
        pixelCount++;
        redColors += Color.red(c);
        greenColors += Color.green(c);
        blueColors += Color.blue(c);
    }
}
// calculate average of bitmap r,g,b values
int red = (redColors/pixelCount);
int green = (greenColors/pixelCount);
int blue = (blueColors/pixelCount);