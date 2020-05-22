PDDocumentCatalog catalog = doc.getDocumentCatalog();
PDAcroForm form = catalog.getAcroForm();
Iterator<PDField> fieldIterator = form.getFieldIterator();
while (fieldIterator.hasNext())
{
    PDField field = fieldIterator.next();
    // ... do stuff ...
}