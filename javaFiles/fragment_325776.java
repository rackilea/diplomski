PDFont font = PDType0Font.load( pdfFile, new File( "fonts/VREMACCI.TTF" ) );  // Windows Russian font imported to write the Russian text.
// Some code here to open the PDF & define a new page.
contentStream.beginText();
contentStream.setFont(font, 12);
contentStream.showText( "отделом компьютерной" ); // Write the Russian text.
contentStream.endText();