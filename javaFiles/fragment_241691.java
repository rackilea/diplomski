try (PDDocument doc = PDDocument.load(new File(file)))
{
    PDFont font = PDType1Font.HELVETICA_BOLD;
    float fontSize = 36.0f;

    for( PDPage page : doc.getPages() )
    {
        PDRectangle pageSize = page.getMediaBox();
        float stringWidth = font.getStringWidth( message )*fontSize/1000f;
        // calculate to center of the page
        int rotation = page.getRotation();
        boolean rotate = rotation == 90 || rotation == 270;
        float pageWidth = rotate ? pageSize.getHeight() : pageSize.getWidth();
        float pageHeight = rotate ? pageSize.getWidth() : pageSize.getHeight();
        float centerX = rotate ? pageHeight/2f : (pageWidth - stringWidth)/2f;
        float centerY = rotate ? (pageWidth - stringWidth)/2f : pageHeight/2f;

        // append the content to the existing stream
        try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true, true))
        {
            contentStream.beginText();
            // set font and font size
            contentStream.setFont( font, fontSize );
            // set text color to red
            contentStream.setNonStrokingColor(255, 0, 0);
            if (rotate)
            {
                // rotate the text according to the page rotation
                contentStream.setTextMatrix(Matrix.getRotateInstance(Math.PI / 2, centerX, centerY));
            }
            else
            {
                contentStream.setTextMatrix(Matrix.getTranslateInstance(centerX, centerY));
            }
            contentStream.showText(message);
            contentStream.endText();
        }
    }

    doc.save( outfile );
}