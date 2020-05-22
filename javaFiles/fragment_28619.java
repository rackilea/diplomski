public Image readImage(byte[] bytes) throws JRException
{
    InputStream bais = new ByteArrayInputStream(bytes);

    Image image = null;
    try
    {
        image = ImageIO.read(bais);
    }
    catch (Exception e)
    {
        throw new JRException(e);
    }
    finally
    {
        try
        {
            bais.close();
        }
        catch (IOException e)
        {
        }
    }

    if (image == null)
    {
        throw new JRException("Image read failed."); // the line #73
    }

    return image;
}