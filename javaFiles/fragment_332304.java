public class UploadTask extends Task<Image> {

    private File file ;
    private BufferedImage bufferedImage ;

    public UploadTask(File file){
        this.file = file;
    }

    @Override
    protected Image call() throws Exception {
        updateMessage("Loading file into memory");
        RandomAccessFile raf = generateRaf(file);
        updateProgress(10, 100);

        updateMessage("Decoding image format");
        TiffDecoder decoder = decodeTiff(raf);
        updateProgress(30, 100);

        updateMessage("Buffering image to stream");
        BufferedImage bufferedImage = bufferImage(decoder);
        updateProgress(600, 100);

        updateMessage("Converting to image");
        Image image = convertImageToFXImage(bufferedImage);
        updateProgress(90, 100);

        updateMessage("Finished");
        updateProgress(100, 100);

        return image;
    }

    private RandomAccessFile generateRaf(File file) throws FileNotFoundException{
        return new RandomAccessFile(file, "r");
    }

    private TiffDecoder decodeTiff(RandomAccessFile raf) throws Exception{
        return new TiffDecoder(raf);
    }

    private BufferedImage bufferImage(TiffDecoder decoder) throws Exception{
       return decoder.read();
    }

    private Image convertImageToFXImage(BufferedImage bufferedImage){
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

    @Override
    protected void failed() {
        System.out.println("Upload failed");
    }

    @Override
    protected void succeeded() {
        System.out.println("Upload succeeded");
    }
}