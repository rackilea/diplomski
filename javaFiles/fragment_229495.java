byte[] template = generateSimpleTemplate();
Files.write(new File(RESULT_FOLDER,  "template.pdf").toPath(), template);

try (   PDDocument finalDoc = new PDDocument(); )
{
    List<PDField> fields = new ArrayList<PDField>();
    int i = 0;

    for (String value : new String[]{"eins", "zwei"})
    {
        PDDocument doc = new PDDocument().load(new ByteArrayInputStream(template));
        PDDocumentCatalog docCatalog = doc.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        PDField field = acroForm.getField("SampleField");
        field.setValue(value);
        field.setPartialName("SampleField" + i++);
        List<PDPage> pages = docCatalog.getAllPages();
        finalDoc.addPage(pages.get(0));
        fields.add(field);
    }

    PDAcroForm finalForm = new PDAcroForm(finalDoc);
    finalDoc.getDocumentCatalog().setAcroForm(finalForm);
    finalForm.setFields(fields);

    finalDoc.save(new File(RESULT_FOLDER, "form-two-templates.pdf"));
}