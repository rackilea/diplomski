public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();
    form.removeXfa();
    form.setField("topmostSubform[0].CopyA[0].Group14-24[0].Line16[0]", "16");
    stamper.close();
    reader.close();
}