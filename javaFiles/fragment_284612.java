public class ImageHolder implements UploadItemWidget {

    public SimplePanel panel = new SimplePanel();

    public FileUpload fileUpload = new FileUpload();

    public ImageHolder() {
        panel.add(fileUpload);
    }
    ...
}