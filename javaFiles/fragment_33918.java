public class MainClass {
    private final FileUploader fileUploader;

    public MainClass(FileUploader fileUploader) {
        this.fileUploader= fileUploader;
    }

    public void startProcess() {
        fileUploader.uploadFile(fileName);
    }
}