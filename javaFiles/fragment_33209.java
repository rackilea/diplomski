@Override
public void onImageAvailable(ImageReader reader) {
    Image image = reader.acquireLatestImage();
    if (image != null) {
        //converting to JPEG
        byte[] jpegData = ImageUtils.imageToByteArray(image);
        //write to file (for example ..some_path/frame.jpg)
        FileManager.writeFrame(FILE_NAME, jpegData);
        image.close();
    }
}