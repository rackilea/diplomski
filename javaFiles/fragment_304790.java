public String getPdfFieldNames() throws IOException {
    if (pdf == null || pdf.isClosed()) {
        throwPdfNotOpenException();
    }
    if (getPdfFormType().equals("XFA")) {
        throwXfaNotSupportedException();
    }

    String s = "";
    Map<String, PdfFormField> map = form.getFormFields();
    for (String key : map.keySet()) {
        PdfName type = form.getField(key).getFormType();
        String simpleFieldType = getSimpleFieldType(form.getField(key), type, key);
        s += "[Field name: " + key + ", Field type: " + simpleFieldType + "]\n";

    }
    s = (s.substring(0, s.length() - 1));

    return s;
}

private String getSimpleFieldType(PdfFormField field, PdfName type, String key) {

     if (0 == PdfName.Btn.compareTo(type)) {
         if(((PdfButtonFormField)form.getField(key)).isPushButton()){
             return "Push Button";
         } else {
             if(((PdfButtonFormField)form.getField(key)).isRadio()){
                 return "Radio Button";                   
             }else {
                 return "Check Box";
             }
         }
     } else if (0 == PdfName.Ch.compareTo(type)) {
         return "List Box";
     } else if (0 == PdfName.Sig.compareTo(type)) {
         return "Signature";
     } else if (0 == PdfName.Tx.compareTo(type)) {
         return "Text Box";

     }else {
         return "Unknown type";
     }
}