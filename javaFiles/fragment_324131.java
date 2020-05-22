public class ComboTest
{
    public static void main(String[] args)
    {

        PDFont font = PDType1Font.HELVETICA;
        Color color = Color.BLACK;
        float fontSize = 12;

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);

        document.addPage(page);

        PDAcroForm acroForm = new PDAcroForm(document);
        PDComboBox comboBox = new PDComboBox(acroForm);
        comboBox.setPartialName("test");

        // Helv instead of Helvetica
        String defaultAppearanceString = "/Helv " + fontSize + " Tf "
                + 0 + " " + 0 + " " + 0 + " rg";
        comboBox.setDefaultAppearance(defaultAppearanceString);

        PDAnnotationWidget widget = new PDAnnotationWidget();
        widget.setRectangle(new PDRectangle(200, 200, 100, 20));
        widget.setAnnotationFlags(4);
        widget.setPage(page);
        widget.setParent(comboBox);

        List<String> exportValues = new ArrayList<>();
        List<String> displayValues = new ArrayList<>();

        displayValues.add("öne");
        displayValues.add("two");
        displayValues.add("thrée");

        exportValues.add("1");
        exportValues.add("2");
        exportValues.add("3");

        comboBox.setOptions(exportValues, displayValues);

        List<PDAnnotationWidget> widgets = new ArrayList<>();
        widgets.add(widget);
        try
        {
            page.getAnnotations().add(widget);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        comboBox.setWidgets(widgets);

        // new
        acroForm.getFields().add(comboBox);
        document.getDocumentCatalog().setAcroForm(acroForm);
        PDResources dr = new PDResources();
        dr.put(COSName.getPDFName("Helv"), font);
        acroForm.setDefaultResources(dr);

        try
        {
            FileOutputStream output = new FileOutputStream("test.pdf");
            document.save(output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}