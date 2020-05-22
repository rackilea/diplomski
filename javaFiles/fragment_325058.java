/**
 * method to shrink pdf file
 * @param writer
 * @param stamper
 * @param reader
 * @param page
 * @param factor
 * @throws IOException 
 */
private void shrink(com.itextpdf.text.pdf.PdfStamper stamper, int page, float factor) throws IOException
{
    com.itextpdf.text.Rectangle crop = stamper.getReader().getCropBox(page);
    float diffX = crop.getRight() * (1 - factor);
    float diffY = crop.getTop() * (1 - factor);
    com.itextpdf.text.pdf.PdfDictionary pageN = stamper.getReader().getPageN(page);
    stamper.markUsed(pageN);
    com.itextpdf.text.pdf.PdfArray ar = null;
    com.itextpdf.text.pdf.PdfObject content = com.itextpdf.text.pdf.PdfReader.getPdfObject(pageN.get(com.itextpdf.text.pdf.PdfName.CONTENTS), pageN);
    if(content == null)
        return;
    if(content.isArray())
    {
        ar = new com.itextpdf.text.pdf.PdfArray((com.itextpdf.text.pdf.PdfArray)content);
        pageN.put(com.itextpdf.text.pdf.PdfName.CONTENTS, ar);
    }
    else if(content.isStream())
    {
        ar = new com.itextpdf.text.pdf.PdfArray();
        ar.add(pageN.get(com.itextpdf.text.pdf.PdfName.CONTENTS));
        pageN.put(com.itextpdf.text.pdf.PdfName.CONTENTS, ar);
    }
    else
        return;
    com.itextpdf.text.pdf.ByteBuffer out_p = new com.itextpdf.text.pdf.ByteBuffer();
    out_p.append(factor).append(" 0 0 ").append(factor).append(' ').append(diffX).append(" ").append(diffY).append(" cm ");
    com.itextpdf.text.pdf.PdfStream stream = new com.itextpdf.text.pdf.PdfStream(out_p.toByteArray());
    ar.addFirst(stamper.getWriter().addToBody(stream).getIndirectReference());
    out_p.reset();
}

/*
* method adding box with "Za zgodnosc..." on the bottom of the page
*/
private void addBoxToPage(com.itextpdf.text.pdf.PdfReader reader, int page, float factor, com.itextpdf.text.pdf.PdfStamper stamper, String operator) throws com.itextpdf.text.DocumentException {
    DecimalFormat df = new DecimalFormat("00");
    DateTime dt = new DateTime();
    int year = dt.getYear();
    int month = dt.getMonthOfYear();
    int day = dt.getDayOfMonth();
    com.itextpdf.text.Rectangle box = reader.getCropBox(page);
    box.setTop(box.getTop() - factor * box.getHeight());
    com.itextpdf.text.pdf.PdfContentByte cb = stamper.getOverContent(page);
    cb.setColorFill(BaseColor.YELLOW);
    cb.setColorStroke(BaseColor.RED);
    cb.rectangle(box.getLeft(), box.getBottom(), box.getWidth(), box.getHeight());
    cb.fillStroke();
    cb.setColorFill(BaseColor.BLACK);
    ColumnText ct = new ColumnText(cb);
    ct.addElement(new Paragraph("Za zgodność z oryginałem Radca Prawny " + operator + ", Wrocław, dnia " + df.format(day) + "-" + df.format(month) + "-" + year + "r.  .................. (podpis)"));
    ct.setSimpleColumn(box);
    ct.go();
}