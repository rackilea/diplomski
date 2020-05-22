public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    List<PdfCleanUpLocation> cleanUpLocations = new ArrayList<PdfCleanUpLocation>();
    cleanUpLocations.add(new PdfCleanUpLocation(1, new Rectangle(97f, 405f, 480f, 445f), BaseColor.GRAY));
    PdfCleanUpProcessor cleaner = new PdfCleanUpProcessor(cleanUpLocations, stamper);
    cleaner.cleanUp();
    stamper.close();
    reader.close();
}