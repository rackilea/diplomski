try (PDDocument doc = PDDocument.load(new File("....")))
{
    PDPageTree pageTree = doc.getPages();
    PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
    for (PDField field : acroForm.getFieldTree())  // null check omitted
    {
        if (field instanceof PDSignatureField)
        {
            PDSignatureField sigField = (PDSignatureField) field;
            for (PDAnnotationWidget widget : sigField.getWidgets())
            {
                PDPage page = widget.getPage();
                if (page != null)
                {
                    System.out.println("Signature on page " + (pageTree.indexOf(widget.getPage()) + 1));
                }
            }
        }
    }
}