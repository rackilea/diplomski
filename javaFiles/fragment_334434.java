public static void main(String[] args) throws Exception
{
    // Instantiating a Workbook object
    Workbook workbook = new Workbook();

    // Accessing the added worksheet in the Excel file
    Worksheet worksheet = workbook.getWorksheets().get(0);
    Cells cells = worksheet.getCells();

    ArrayList<String> values = new ArrayList<String>();
    ArrayList<Style> styles = new ArrayList<Style>();

    // Separator character
    String separator = " ";

    // I
    values.add("I");
    styles.add(new Style()); styles.get(0).getFont().setBold(true);
    // Want
    values.add("Want");
    styles.add(new Style()); styles.get(1).getFont().setBold(false);
    // Some
    values.add("Some");
    styles.add(new Style()); styles.get(2).getFont().setBold(true);
    // Help
    values.add("Help");
    styles.add(new Style()); styles.get(3).getFont().setBold(false);

    // Get cell A1
    Cell cell = cells.get("A1");

    appendValuesWithStyles(cell, values, styles, separator);

    workbook.save(Common.DATA_DIR + "cellstyle.xlsx");
}

private static void appendValuesWithStyles(Cell cell, ArrayList<String> values, ArrayList<Style> styles, String separator)
{
    // Lets combine all chunks, because we can only use setValue()
    String allCharacters = "";
    // First set the whole value in cell
    int iValue = 0;
    for (String value : values)
    {
        allCharacters = allCharacters + value;
        if (iValue < values.size())
            allCharacters = allCharacters + separator;

        iValue++;
    }

    // Set the value once
    cell.setValue(allCharacters);

    // Now set the styles
    int startIndex = 0, valueLength = 0;
    for (int iStyle = 0 ; iStyle < styles.size() ; iStyle++)
    {
        // Get the associated value and the style.
        String value = values.get(iStyle);
        Style style = styles.get(iStyle);

        // We need the start character and length of string to set the style
        valueLength = value.length();

        cell.characters(startIndex, valueLength).getFont().setBold(style.getFont().isBold());

        // Increment the start index
        startIndex = startIndex + valueLength + separator.length();
    }
}