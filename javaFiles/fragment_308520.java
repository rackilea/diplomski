Workbook workbook = Workbook.getWorkbook(new File("myfile.xls"));
Sheet sheet = workbook.getSheet(0);
for (int i = 0; i < sheet.getRows(); i++) {
    boolean c1Empty = sheet.getCell(0, i).getContents().isEmpty();
    boolean c2Empty = sheet.getCell(1, i).getContents().isEmpty();
    boolean c3Empty = sheet.getCell(2, i).getContents().isEmpty();
    boolean c4Empty = sheet.getCell(3, i).getContents().isEmpty();
    if (c1Empty && c2Empty && c3Empty && c4Empty) {
        throw new RuntimeException("If the first three columns are empty then the fourth column can not empty.");
    }
    // Redundant
    //if (c4Empty && c1Empty && c2Empty && c3Empty) {
    //    throw new RuntimeException("If the fourth column is empty then all the three columns should not be empty.");
    //}
}