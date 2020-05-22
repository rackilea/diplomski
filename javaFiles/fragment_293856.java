public BufferedImage convertToImage() throws IOException
{
    //note we are doing twice as many pixels because
    //the default size is not really good resolution,
    //so create an image that is twice the size
    //and let the client scale it down.
    return convertToImage(8, 2 * DEFAULT_USER_SPACE_UNIT_DPI);
}