// get the dimensions of your 2D array from your tempTable size
// which will be columns * rows long
String[][] outArr = new String[tempTable.size()/columns][columns]

for (int subStart = 0; subStart < tempTable.size(); subStart += columns)
{
    ArrayList<String> tempTable1 = new ArrayList<String>(
                                     tempTable.subList(subStart, subStart+columns));
    int rownum = subStart / columns;

    // each "tempTable1" represents a row in the table - write
    // this element by element to your 2D String array.
    for (int i = 0; i < columns; i++)
    {
        outArr[rownum][i] = tempTable1.get(i);
    }

    String tableonLine = tempTable1.toString().replaceAll("[^a-zA-Z0-9\\-:.,]", " ");

    System.out.println("Sublist "+ rownum + ": "+tableonLine);
}