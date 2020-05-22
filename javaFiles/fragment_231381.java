int col[]={255,255,255};

WritableRaster raster1=img.getRaster();

for(int i=0;i<width;i++)
{
    for(int j=0;j<height;j++)
    {
        raster1.setPixel(i, j, col);
    }
}