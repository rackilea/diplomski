//img is your black and white image of type BufferedImage

// Get the width and height of your image
int width = img.getWidth();
int height = img.getHeight();

// create a BitSet of the correct size      
BitSet bits = new BitSet(width * height);

// Iterate through your image's pixels and set the correct bits.
for (int y = 0; y < height; ++y)
{
    for (int x = 0; x < width; ++x)
    {
        // Check against 0xffffffff which is the RGB value of white.
        if (img.getRGB(x, y) == 0xffffffff)
        {
            bits.set(y * width + x);
        }
    }
}