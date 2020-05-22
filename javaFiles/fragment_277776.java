FontFactory factory = FontFactory.getInstance();
Font[] fonts = factory.loadFonts( ... ); // pulls every TTF out of TTC
ArrayList<PDTrueTypeFont> pdf_fonts = new ArrayList<PDTrueTypeFont>();
for( Font f : fonts ){
   // sfntly writes each font to a TTF stream
   ByteArrayOutputStream out = ByteArrayOutputStream();
   factory.serializeFont(f, out);

   // PDFBox reads the stream and embeds the font
   ByteArrayInputStream ttf_font_stream = ByteArrayInputStream(out.toByteArray());
   pdf_fonts.add(PDTrueTypeFont.loadTTF(document, ttf_font_stream));
}