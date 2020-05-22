class MyReader extends PdfReader {
    public MyReader(final String filename, final byte password[]) throws IOException {
        super(filename, password);
    }
    public void decryptOnPurpose() {
        encrypted = false;
    }
}

public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    MyReader.unethicalreading = true;
    MyReader reader = new MyReader(src, "abc123".getBytes());
    reader.decryptOnPurpose();
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
    reader.close();
}