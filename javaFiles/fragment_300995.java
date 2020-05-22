@Override
protected void mergePdfDocument(Map<String,Object> model,
                                     com.lowagie.text.pdf.PdfStamper stamper,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
                              throws Exception {

    // follow example code for filling out a form using iText:
    // http://itextpdf.com/examples/iia.php?id=122

    AcroFields form = stamper.getAcroFields();
    // form.setField("fieldName", model.get("fieldName"));
}