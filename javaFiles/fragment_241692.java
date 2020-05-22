PDDocument doc = null;
try
{
    doc = PDDocument.load( file );

    List allPages = doc.getDocumentCatalog().getAllPages();
    PDFont font = PDType1Font.HELVETICA_BOLD;
    float fontSize = 36.0f;

    for( int i=0; i<allPages.size(); i++ )
    {
        PDPage page = (PDPage)allPages.get( i );
        PDRectangle pageSize = page.findMediaBox();
        float stringWidth = font.getStringWidth( message )*fontSize/1000f;
        // calculate to center of the page
        int rotation = page.findRotation(); 
        boolean rotate = rotation == 90 || rotation == 270;
        float pageWidth = rotate ? pageSize.getHeight() : pageSize.getWidth();
        float pageHeight = rotate ? pageSize.getWidth() : pageSize.getHeight();
        double centeredXPosition = rotate ? pageHeight/2f : (pageWidth - stringWidth)/2f;
        double centeredYPosition = rotate ? (pageWidth - stringWidth)/2f : pageHeight/2f;
        // append the content to the existing stream
        PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true,true);
        contentStream.beginText();
        // set font and font size
        contentStream.setFont( font, fontSize );
        // set text color to red
        contentStream.setNonStrokingColor(255, 0, 0);
        if (rotate)
        {
            // rotate the text according to the page rotation
            contentStream.setTextRotation(Math.PI/2, centeredXPosition, centeredYPosition);
        }
        else
        {
            contentStream.setTextTranslation(centeredXPosition, centeredYPosition);
        }
        contentStream.drawString( message );
        contentStream.endText();
        contentStream.close();
    }

    doc.save( outfile );
}
finally
{
    if( doc != null )
    {
        doc.close();
    }
}