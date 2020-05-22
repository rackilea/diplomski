public static final void main(String... args) throws Exception
{
    InputStream is = ExcelFormatTest.class.getResourceAsStream("Test.xlsx");
    Workbook wb = new XSSFWorkbook(is);
    Sheet sheet = wb.getSheetAt(0);
    Cell cell = sheet.getRow(0).getCell(0);
    XSSFRichTextString richText = (XSSFRichTextString)cell.getRichStringCellValue();
    int formattingRuns = cell.getRichStringCellValue().numFormattingRuns();

    for(int i = 0; i < formattingRuns; i++)
    {
        int startIdx = richText.getIndexOfFormattingRun(i);
        int length = richText.getLengthOfFormattingRun(i);
        System.out.println("Text: " + richText.getString().substring(startIdx, startIdx + length));
        if(i == 0)
        {
            short fontIndex = cell.getCellStyle().getFontIndex();
            Font f = wb.getFontAt(fontIndex);
            System.out.println("Bold: " + (f.getBoldweight() == Font.BOLDWEIGHT_BOLD));
            System.out.println("Italics: " + f.getItalic() + "\n");
        }
        else
        {
            Font f = richText.getFontOfFormattingRun(i);
            System.out.println("Bold: " + (f.getBoldweight() == Font.BOLDWEIGHT_BOLD));
            System.out.println("Italics: " + f.getItalic() + "\n");
        }
    }
}