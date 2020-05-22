for(int y = -r; y < r; y++)
{
    int bound = (int)(sqrt(r * r - y * y) + 0.5);
    for(int x = -bound; x < bound; x++)
    {
         raster.setPixel(x,y,color);
    }
}