public class ExcelWithHtml {
    // <html><p>This is a test. Will this text be <b>bold</b> or
    // <i>italic</i></p></html>

    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        new ExcelWithHtml()
                .readFirstCellOfXSSF("/Users/rcacheira/testeHtml.xlsx");
    }

    boolean inBold = false;
    boolean inItalic = false;

    public void readFirstCellOfXSSF(String filePathName)
            throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(filePathName);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        String cellHtml = getHtmlFormatedCellValueFromSheet(sheet, "A1");

        System.out.println(cellHtml);

        fis.close();
    }

    public String getHtmlFormatedCellValueFromSheet(XSSFSheet sheet,
            String cellName) {

        CellReference cellReference = new CellReference(cellName);
        XSSFRow row = sheet.getRow(cellReference.getRow());
        XSSFCell cell = row.getCell(cellReference.getCol());

        XSSFRichTextString cellText = cell.getRichStringCellValue();

        String htmlCode = "";
        // htmlCode = "<html>";

        for (int i = 0; i < cellText.numFormattingRuns(); i++) {
            try {
                htmlCode += getFormatFromFont(cellText.getFontAtIndex(i));
            } catch (NullPointerException ex) {
            }
            try {
                htmlCode += getFormatFromFont(cellText
                        .getFontOfFormattingRun(i));
            } catch (NullPointerException ex) {
            }

            int indexStart = cellText.getIndexOfFormattingRun(i);
            int indexEnd = indexStart + cellText.getLengthOfFormattingRun(i);

            htmlCode += cellText.getString().substring(indexStart, indexEnd);
        }

        if (inItalic) {
            htmlCode += "</i>";
            inItalic = false;
        }
        if (inBold) {
            htmlCode += "</b>";
            inBold = false;
        }

        // htmlCode += "</html>";
        return htmlCode;

    }

    private String getFormatFromFont(XSSFFont font) {
        String formatHtmlCode = "";
        if (font.getItalic() && !inItalic) {
            formatHtmlCode += "<i>";
            inItalic = true;
        } else if (!font.getItalic() && inItalic) {
            formatHtmlCode += "</i>";
            inItalic = false;
        }

        if (font.getBold() && !inBold) {
            formatHtmlCode += "<b>";
            inBold = true;
        } else if (!font.getBold() && inBold) {
            formatHtmlCode += "</b>";
            inBold = false;
        }

        return formatHtmlCode;
    }

}