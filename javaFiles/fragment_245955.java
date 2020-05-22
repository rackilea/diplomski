public static void setIconImages(final java.awt.Window window, 
                                 final List<? extends Image> icons) 
{
    try
    {
        Method setIconImagesMethod;

        setIconImagesMethod = // use reflection to get the setIconImages method. 
        setIconImagesMethod.invoke(window, icons);
    }
    catch(final NoSuchMethodException ex)
    {
        // fall back to the single image method
        window.setIconImage(icons.get(0));
    }
}