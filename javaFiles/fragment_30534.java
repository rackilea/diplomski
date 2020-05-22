int GetBaseIndexOfPlane(int plane, int imageWidth, int imageHeight)
{
    if (plane == 0)
        return 0;
    else
        return imageWidth * imageHeight;
}