//PDF READER
// Create a reader  
try{
    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    PdfReader reader = new PdfReader(output.toByteArray());
    PdfStamper stamper = new PdfStamper(reader, out);
    int n = reader.getNumberOfPages();
    PdfContentByte cbq;
    Font headerFont = new Font(FontFamily.COURIER, 13, Font.UNDERLINE);
    for (int i = 1; i <= n; i++) {
        cbq = stamper.getOverContent(i);
        ColumnText ct = new ColumnText( cbq );
        ct.setSimpleColumn( 300 , 300, 50, 50 , 150, Element.ALIGN_CENTER );
        ct.addElement( new Paragraph( "Mathias" , headerFont ) );
        ct.go();
    }
    // Close the stamper
    stamper.close();
    reader.close();
    response.setContentLength(out.size());
    OutputStream os = response.getOutputStream();
    out.writeTo(os);
} catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}