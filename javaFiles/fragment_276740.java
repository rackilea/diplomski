PDPageContentStream contentStream = new PDPageContentStream(doc,  page);
contentStream.beginText();
contentStream.newLineAtOffset(..., ...);
contentStream.showText(...);
contentStream.endText();
contentStream.close();