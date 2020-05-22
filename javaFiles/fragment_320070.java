// Tesseract can only handle .tif format, so we have to convert it
ImageIO.write( ImageIO.read( new java.io.File(file.getPath())), "tif", tmpFile[0]);

String[] tesseractCmd = new String[]{"tesseract", tmpFile[0].getAbsolutePath(), StringUtils.removeEnd(tmpFile[1].getAbsolutePath(), ".txt")};
final Process process = Runtime.getRuntime().exec(tesseractCmd);
try {
    int exitValue = process.waitFor();
    if(exitValue == 0) {
        final String extractedText = SearchableTextExtractionUtils.extractPlainText(new FileReader(tmpFile[1]));
        return extractedText;
    }
    throw new SearchableTextExtractionException(exitValue, Arrays.toString(tesseractCmd));
} catch (InterruptedException e) {
    throw new SearchableTextExtractionException(e);
} finally {
    process.destroy();
}