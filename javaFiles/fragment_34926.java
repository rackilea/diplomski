PdfTemplate topOfPage = writer.getImportedPage( reader, 1 );
PdfTemplate bottomOfPage = writer.getImportedPage( reader, 2 );

PdfContentByte content = writer.getDirectContent();

// in PDF, "0, 0" is the lower left corner.
content.addTemplate( bottomOfPage );
content.addTemplate( topOfPage, 0, bottomOfPage.getHeight() );