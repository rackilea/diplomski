public static void setFieldBold(String name, String value) throws IOException
{
    PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
    PDAcroForm acroForm = docCatalog.getAcroForm();
    PDField field = acroForm.getField(name);

    COSDictionary dict = ((PDField) field).getDictionary();
    COSString defaultAppearance = (COSString) dict
            .getDictionaryObject(COSName.DA);
    if (defaultAppearance != null)
    {
        dict.setString(COSName.DA, "/Helv 10 Tf 2 Tr .5 w 0 g");
        if (name.equalsIgnoreCase("Field1")) {
            dict.setString(COSName.DA, "/Helv 12 Tf 0 g");
        }
    }
    if (field instanceof PDTextbox)
    {
        field = new PDTextbox(acroForm, dict);
        ((PDField) field).setValue(value);
    }
}