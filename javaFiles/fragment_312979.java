...
String strCellValue;
DataFormatter df = new DataFormatter();
for (Row row : sheet) {
    for (Cell cell : row) {
        switch (formEvaluator.evaluateInCell(cell).getCellType()) {

        case Cell.CELL_TYPE_NUMERIC:
            strCellValue = df.formatCellValue(cell);
            if (DateUtil.isCellDateFormatted(cell)) {
                if (strCellValue.length() > 5) {
                    System.out.print(df.formatCellValue(cell) + "...");
                } else {
                    System.out.print(df.formatCellValue(cell));
                }
                System.out.print("|");
            } else {
                if (strCellValue.length() > 5) {
                    System.out.print(cell.getNumericCellValue() + "...");
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                System.out.print("|");
            }
            break;

        case Cell.CELL_TYPE_STRING:
            strCellValue = df.formatCellValue(cell);
            if (strCellValue.length() > 5) {
                System.out.print(cell.getStringCellValue() + "...");
            } else {
                System.out.print(cell.getStringCellValue());
            }
            System.out.print("|");
            break;

        case Cell.CELL_TYPE_ERROR:
            strCellValue = df.formatCellValue(cell);
            if (strCellValue.length() > 5) {
                System.out.print(cell.getErrorCellValue() + "...");
            } else {
                System.out.print(cell.getErrorCellValue());
            }
            System.out.print("|");
            break;
        }
    }

    System.out.println();
}
...