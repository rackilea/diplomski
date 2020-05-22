import org.apache.pdfbox.util.PDFTextStripper;

PDFTextStripper stripper = new PDFTextStripper;

public static String pdfbox(InputStream is, Writer writer) throws IOException, ConversionException {
        Boolean force = true;

        PDDocument document = null;
        try {
            document = PDDocument.load(is, force); // force extraction

            stripper.setForceParsing(force); // continue when errors are encountered.
            stripper.setSortByPosition(false); // text may not be in visual order.
            stripper.setShouldSeparateByBeads(true); // beads are columns, attempt to handle them.

            stripper.writeText(document, writer);
        }
        finally {
            try {
                if (document != null) {
                    document.close();
                }
            }
            catch (Exception e) {
                throw new ConversionException(e);
            }
        }
    }