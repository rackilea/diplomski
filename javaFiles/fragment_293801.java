public class ImagePreview {

    private String name;
    private ImageIcon image;

    public ImagePreview(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
    }

    public String getDescription() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }

    protected void setDescription(String description) {
        this.name = description;
    }

}