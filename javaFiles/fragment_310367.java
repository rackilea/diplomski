public void addTextField(PdfWriter writer, Rectangle rect, String name) {
    PdfFormField field = PdfFormField.createTextField(writer, false, false, 0);
     field.setFieldName(name);
     field.setWidget(rect, PdfAnnotation.HIGHLIGHT_NONE);
     field.setQuadding(PdfFormField.Q_RIGHT);
     field.setFieldFlags(PdfFormField.FF_READ_ONLY);
     writer.addAnnotation(field);
}    

public void addPushButton(PdfWriter writer, Rectangle rect, String btn, String script) {
    float w = rect.getWidth();
    float h = rect.getHeight();
    PdfFormField pushbutton = PdfFormField.createPushButton(writer);
    pushbutton.setFieldName("btn_" + btn);
    pushbutton.setWidget(rect, PdfAnnotation.HIGHLIGHT_PUSH);
    PdfContentByte cb = writer.getDirectContent();
    pushbutton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, createAppearance(cb, btn, BaseColor.GRAY, w, h));
    pushbutton.setAppearance(PdfAnnotation.APPEARANCE_ROLLOVER, createAppearance(cb, btn, BaseColor.RED, w, h));
    pushbutton.setAppearance(PdfAnnotation.APPEARANCE_DOWN, createAppearance(cb, btn, BaseColor.BLUE, w, h));
    pushbutton.setAdditionalActions(PdfName.U, PdfAction.javaScript(script, writer));
    pushbutton.setAdditionalActions(PdfName.E, PdfAction.javaScript( "this.showMove('" + btn + "');", writer));
    pushbutton.setAdditionalActions(PdfName.X, PdfAction.javaScript( "this.showMove(' ');", writer));
    writer.addAnnotation(pushbutton);
}

public PdfAppearance createAppearance(PdfContentByte cb, String btn, BaseColor color, float w, float h) {
    PdfAppearance app = cb.createAppearance(w, h);
    app.setColorFill(color);
    app.rectangle(2, 2, w - 4, h - 4);
    app.fill();
    app.beginText();
    app.setColorFill(BaseColor.BLACK);
    app.setFontAndSize(bf, h / 2);
    app.showTextAligned(Element.ALIGN_CENTER, btn, w / 2, h / 4, 0);
    app.endText();
    return app;
}