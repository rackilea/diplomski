PdfDocument document = new PdfDocument(new PdfReader(INPUT), new PdfWriter(OUTPUT));

PdfAcroForm form = PdfAcroForm.getAcroForm(document, true);

form.partialFormFlattening(nameOfTheButtonField);
form.flattenFields();

document.close();