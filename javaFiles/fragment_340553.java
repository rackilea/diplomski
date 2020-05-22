PdfReader reader = new PdfReader(pdf);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(RESULT));
List<com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpLocation> locations = new ArrayList<>();
locations.add(new com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpLocation(1, new Rectangle(150, 150, 350, 350), BaseColor.RED));
new PdfCleanUpProcessor(locations, stamper).cleanUp();
stamper.close();