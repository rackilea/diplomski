public final class MyImageLoader
{
    // Utility class: no instantiation
    private MyImageLoader() {}

    public static ImageIcon getImage(final String resourcePath)
    {
        final URL url = MyImageLoader.class.getResource(resourcePath);
        return new ImageIcon(url);
    }
}