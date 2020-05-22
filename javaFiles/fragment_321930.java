public static final String SRC = "resources/pdfs/image.pdf";
public static final String DEST = "results/parse/stream%s";

public static void main(String[] args) throws IOException {
    File file = new File(DEST);
    file.getParentFile().mkdirs();
    new ExtractStreams().parse(SRC, DEST);
}

public void parse(String src, String dest) throws IOException {
    PdfReader reader = new PdfReader(src);
    PdfObject obj;
    for (int i = 1; i <= reader.getXrefSize(); i++) {
        obj = reader.getPdfObject(i);
        if (obj != null && obj.isStream()) {
            PRStream stream = (PRStream)obj;
            byte[] b;
            try {
                b = PdfReader.getStreamBytes(stream);
            }
            catch(UnsupportedPdfException e) {
                b = PdfReader.getStreamBytesRaw(stream);
            }
            FileOutputStream fos = new FileOutputStream(String.format(dest, i));
            fos.write(b);
            fos.flush();
            fos.close();
        }
    }
}