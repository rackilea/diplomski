PdfReader reader = new PdfReader(src);
PdfDocument pdfDoc = new PdfDocument(reader);
// Get the fields from the reader (read-only!!!)
PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
// Loop over the fields and get info about them
Set<String> fields = form.getFormFields().keySet();
for (String key : fields) {
    writer.print(key + ": ");
    PdfName type = form.getField(key).getFormType();
    if (0 == PdfName.Btn.compareTo(type)) {
        if(((PdfButtonFormField)form.getField(key)).isPushButton()){
            writer.println("Pushbutton");
        } else {
            if(((PdfButtonFormField)form.getField(key)).isRadio()){
                writer.println("Radiobutton");                   
            }else {
                writer.println("Checkbox");
            }
        }
    } else if (0 == PdfName.Ch.compareTo(type)) {
        writer.println("Choicebox");
    } else if (0 == PdfName.Sig.compareTo(type)) {
        writer.println("Signature");
    } else if (0 == PdfName.Tx.compareTo(type)) {
        writer.println("Text");
    }else {
        writer.println("?");
    }
}