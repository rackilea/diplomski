DirectColorModel resizedModel = (DirectColorModel) resizedImage.getColorModel();
int numPixels = resizedImage.getWidth() * resizedImage.getHeight();

byte[numPixels] reds;
byte[numPixels] blues;
byte[numPixels] greens;
byte[numPixels] alphas;
int curIndex = 0;
int curPixel;

for (int i = 0; i < resizedImage.getWidth(); i++)
{
    for (int j = 0; j < resizedImage.getHeight(); j++)
    {
        curPixel = resizedImage.getRGB(i, j);
        reds[curIndex] = resizedModel.getRed(curPixel);
        blues[curIndex]= resizedModel.getBlue(curPixel);
        greens[curIndex] = resizedModel.getGreen(curPixel);
        alphas[curIndex] = resizedModel.getAlpha(curPixel);
        curIndex++;
    }
}

BufferedImage indexedImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_BYTE_INDEXED, new IndexColorModel(resizedModel.pixel_bits, numPixels, reds, blues, greens, alphas));