public class MMM {
    static void mergeCells(XSSFSheet sheet, String cells) {
        String regex = "([A-Z]+)(\\d+):([A-Z]+)(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cells);

        if(matcher.matches()) {
            int col1 = CellReference.convertColStringToIndex(matcher.group(1));
            int col2 = CellReference.convertColStringToIndex(matcher.group(3));

            int row1 = Integer.parseInt(matcher.group(2)) - 1;
            int row2 = Integer.parseInt(matcher.group(4)) - 1;

            sheet.addMergedRegion(new CellRangeAddress(row1, row2, col1, col2));
        }
    }

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("wwww2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        mergeCells(sheet, "AAD10:ADD23");

        workbook.write(outputStream);
        outputStream.close();
    }
}