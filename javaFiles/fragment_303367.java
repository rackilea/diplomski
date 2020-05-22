public class ImageHolder implements Serializable {

    BufferedImage image;

    public ImageHolder(BufferedImage image) {
        this.image = image;
    }

    private void readObject(ObjectInputStream stream) 
            throws IOException, ClassNotFoundException {
        image = ImageIO.read(stream);
    }

    private void writeObject(ObjectOutputStream stream) 
            throws IOException {
        ImageIO.write(image, "PNG", stream);
    }

    private void readObjectNoData() throws ObjectStreamException {
        // leave image as null
    }