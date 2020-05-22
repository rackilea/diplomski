public class ImageSelection {

    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();

    private static ImageSelection imageSelectionInstance= new ImageSelection();

    private ImageSelection(){}

    public static ImageSelection getImageSelectionInstance() {
        return imageSelectionInstance;
    }

    public ObjectProperty<Image> imageProperty() {
        return image ;
    }

    public final void setImage(Image image) {
        imageProperty().set(image);
    }

    public final Image getImage()
    {
        return imageProperty().get();
    }

}