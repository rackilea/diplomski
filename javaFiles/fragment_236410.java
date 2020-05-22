Public SimpleRGB getRedImage()
{

    SimpleRGB redImage = new SimpleRGB(int,int);     

    for (int i = 0; i < width; i++)
    {
        For (int j  0; j < height; j++)
        {
            redImage.red[i][j] = ??;  
            redImage.green[i][j] = 0;
            redImage.blue[i][j] = 0;
        }
    }

    Return redImage; //removed the ()
}