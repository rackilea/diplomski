package it.sephiroth.listviewwithselectallcheckbxox;
public class RowItem {
    private int imageId;
    private String imageUrl;

    public RowItem(int imageId) {
        this.imageId = imageId;
    }

    public RowItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getimageUrl() {
        return imageUrl;
    }
    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}