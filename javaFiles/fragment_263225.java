PdfFormField radiogroup = PdfFormField.createRadioButton(writer, true);
radiogroup.setFieldName("Language");
PdfPTable table = new PdfPTable(2);
// add cells
document.add(table);
writer.addAnnotation(radiogroup);