private StreamedContent fileDownload;

  public void createPDF() {
    try {       
        Document pdf = new Document(PageSize.LETTER);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer;
        writer = PdfWriter.getInstance(pdf, baos);
        if (!pdf.isOpen()) {
            pdf.open();
        }

       //Adding content to pdf

        pdf.close();
        String fileName = "factura No " + this.selectedFactura.getNoFactura();

        InputStream stream = new ByteArrayInputStream(baos.toByteArray());
        fileDownload = new DefaultStreamedContent(stream, "application/pdf", fileName);

    } catch (Exception e) {
        JsfUtil.addErrorMessage(e, "Error: createPDF() " + e.getMessage());
    }
}