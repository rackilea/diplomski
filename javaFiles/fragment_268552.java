// RESCALEIMAGE
// scales an image according to the ratios given as parameters
// derived from http://willperone.net/Code/codescaling.php

public static Image rescaleImage(Image original, double XRatio, double YRatio)
{
    // the original width and height
    int originalWidth = original.getWidth();
    int originalHeight = original.getHeight();

    // the target width and height
    int newWidth = (int)(XRatio * originalWidth);
    int newHeight = (int)(YRatio * originalHeight);

    // create and fill the pixel array from the original image
    int[] rawInput = new int[originalHeight * originalWidth];
    original.getRGB(rawInput, 0, originalWidth, 0, 0, originalWidth, originalHeight);

    // pixel array for the target image
    int[] rawOutput = new int[newWidth*newHeight];

    // YD compensates for the x loop by subtracting the width back out
    int YD = (originalHeight / newHeight) * originalWidth - originalWidth;
    int YR = originalHeight % newHeight;
    int XD = originalWidth / newWidth;
    int XR = originalWidth % newWidth;
    int outOffset= 0;
    int inOffset=  0;

    for (int y = newHeight, YE = 0; y > 0; y--)
    {
        for (int x = newWidth, XE = 0; x > 0; x--)
        {
            rawOutput[outOffset++] = rawInput[inOffset];

            inOffset += XD;
            XE += XR;

            if (XE >= newWidth)
            {
                XE -= newWidth;
                inOffset++;
            }
        }

        inOffset += YD;
        YE += YR;

        if (YE >= newHeight)
        {
            YE -= newHeight;
            inOffset += originalWidth;
        }
    }
    return Image.createRGBImage(rawOutput, newWidth, newHeight, true);
}