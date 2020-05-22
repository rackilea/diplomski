/**
 * Adds page breaks (columns and rows) to a sheet
 *
 * @param pageBreaks
 *            list of page breaks objects that contain the name of the sheet, as well as the column and row page breaks
 */
public static void addPageBreaks(ArrayList<PageBreak> pageBreaks)
{
    try
    {
        // Iterate for each page break object
        for (int i = 0; i < pageBreaks.size(); i++)
        {
            // Get sheet from page break object
            HSSFSheet sheet = workbook.getSheet(pageBreaks.get(i).getSheetName());

            // Line needed to set the page breaks in the page
            sheet.setAutobreaks(false);

            // Iterate over all the row page breaks
            if (pageBreaks.get(i).getRowPageBreaks() != null)
            {
                for (int j = 0; j < pageBreaks.get(i).getRowPageBreaks().size(); j ++)
                {
                    sheet.setRowBreak(pageBreaks.get(i).getRowPageBreaks().get(j));
                }
            }

            // Iterate over all the column page breaks
            if (pageBreaks.get(i).getColumnPageBreaks() != null)
            {
                for (int j = 0; j < pageBreaks.get(i).getColumnPageBreaks().size(); j ++)
                {
                    sheet.setColumnBreak(pageBreaks.get(i).getColumnPageBreaks().get(j));
                }
            }
        }

        fileOut = new FileOutputStream(excelFile);

        workbook.write(fileOut);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

public class PageBreak
{
private String sheetName;
private ArrayList<Integer> columnPageBreaks;
private ArrayList<Integer> rowPageBreaks;

/**
  * Constructor.
  *
  * @param sheetName
  *            name of the sheet to add page breaks to
  * @param rowPageBreaks
  *            list of rows which to add page breaks to
  * @param columnPageBreaks
  *            list of columns which to add page breaks to
  */
public PageBreak(String sheetName, ArrayList<Integer> rowPageBreaks, ArrayList<Integer> columnPageBreaks)
{
    this.sheetName = sheetName;
    this.rowPageBreaks = rowPageBreaks;
    this.columnPageBreaks = columnPageBreaks;
}

/**
  * Constructor.
  *
  * @param sheetName
  *            name of the sheet to add page breaks to
  */
public PageBreak(String sheetName)
{
    this.sheetName = sheetName;
    rowPageBreaks = new ArrayList<Integer>();
    columnPageBreaks = new ArrayList<Integer>();
}

/**
  * Adds a column page break to the list of column page breaks
  *
  * @param columnPageBreak
  *            number of the column which to set as a page break
  */
public void addColumnPageBreak(int columnPageBreak)
{
    columnPageBreaks.add(columnPageBreak);
}

/**
  * Adds a row page break to the list of row page breaks
  *
  * @param rownPageBreak
  *            number of the row which to set as a page break
  */
public void addRowPageBreak(int rowPageBreak)
{
    rowPageBreaks.add(rowPageBreak);
}

public ArrayList<Integer> getColumnPageBreaks()
{
    return columnPageBreaks;
}

public ArrayList<Integer> getRowPageBreaks()
{
    return rowPageBreaks;
}

public String getSheetName()
{
    return sheetName;
}

public void setColumnPageBreaks(ArrayList<Integer> columnPageBreaks)
{
    this.columnPageBreaks = columnPageBreaks;
}

public void setRowPageBreaks(ArrayList<Integer> rowPageBreaks)
{
    this.rowPageBreaks = rowPageBreaks;
}

public void setSheetName(String sheetName)
{
    this.sheetName = sheetName;
}