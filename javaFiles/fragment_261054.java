public static void main(String[] args) throws IOException
{
    PDDocument doc = PDDocument.load(new File("ZPe.pdf"));
    PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
    PDResources dr = acroForm.getDefaultResources();

    // Important: the font is Type0 (allows more than 256 glyphs) and NOT SUBSETTED
    PDFont font = PDType0Font.load(doc, new FileInputStream("c:/windows/fonts/arial.ttf"), false);

    COSName fontName = dr.add(font);
    Iterator<PDField> it = acroForm.getFieldIterator();
    while (it.hasNext())
    {
        PDField field = it.next();
        if (field instanceof PDTextField)
        {
            PDTextField textField = (PDTextField) field;
            String da = textField.getDefaultAppearance();

            // replace font name in default appearance string
            Pattern pattern = Pattern.compile("\\/(\\w+)\\s.*");
            Matcher matcher = pattern.matcher(da);
            if (!matcher.find() || matcher.groupCount() < 2)
            {
                // oh-oh
            }
            String oldFontName = matcher.group(1);
            da = da.replaceFirst(oldFontName, fontName.getName());

            textField.setDefaultAppearance(da);
        }
    }
    acroForm.getField("name1").setValue("Наслов");
    doc.save("result.pdf");
    doc.close();
}