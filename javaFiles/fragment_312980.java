...
String strCellValue;
DataFormatter df = new DataFormatter();
for (Row row : sheet) {
    for (Cell cell : row) {
        strCellValue = df.formatCellValue(cell);
        if (strCellValue.length() > 5) {
            System.out.print(df.formatCellValue(cell) + "...");
        } else {
            System.out.print(df.formatCellValue(cell));
        }
        System.out.print("|");
    }
    System.out.println();
}
...