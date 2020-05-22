class GalleryImage implements Serializable
{
    private Image image;
    private transient Image thumbnailImage;

    private void generateThumbnail()
    {
        // Generate thumbnail.
    }

    private void readObject(ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException
    {
        inputStream.defaultReadObject();
        generateThumbnail();
    }    
}