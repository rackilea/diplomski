public class DImage extends QImage implements Serializable {
protected int imageId;

public DImage(String imagePath) {
    super(imagePath); // <-- you have to call the constructor
    imageId = 0;
}