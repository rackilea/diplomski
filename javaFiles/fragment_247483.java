public SimpleRGB getRedImage()
{
    SimpleRGB redImage = new SimpleRGB(width, height);

    for (int i = 0; i < width; i++)
    {
        for (int j = 0; j < height; j++)
        {
            redImage.setRed(i, j, getRed(i, j));
            redImage.setGreen(i, j, getGreen(i, j, 0);
            redImage.setBlue(i, j, getBlue(i, j, 0));
        }
    }

return redImage;
}