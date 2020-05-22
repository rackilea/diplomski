class MyCellField implements PdfPCellEvent {
    protected PdfFormField radiogroup;
    protected String value;
    public MyCellField(PdfFormField radiogroup, String value) {
        this.radiogroup = radiogroup;
        this.value = value;
    }
    public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
        final PdfWriter writer = canvases[0].getPdfWriter();
        RadioCheckField radio = new RadioCheckField(writer, rectangle, null, value);
        try {
            radiogroup.addKid(radio.getRadioField());
        } catch (final IOException ioe) {
            throw new ExceptionConverter(ioe);
        } catch (final DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }
}