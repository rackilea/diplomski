public class ImageItem {

    private int arrayIndex;
    private int imageResource;
    private String title;

    public ImageItem(int arrayIndex, int imageResource, String title) {
        super();
        this.arrayIndex = arrayIndex;
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    // rest methods should be same

}