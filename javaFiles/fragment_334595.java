public class ZipOutputURIReslover implements OutputURIResolver{

    private ZipOutputStream zipOut;

    public ZipOutputURIReslover(ZipOutputStream zipOut) {
        super();
        this.zipOut = zipOut;
    }

    public void close(Result arg0) throws TransformerException {
        try {
            zipOut.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result resolve(String href, String base) throws TransformerException {
        try {
            zipOut.putNextEntry(new ZipEntry(href));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StreamResult(zipOut);
    }
}