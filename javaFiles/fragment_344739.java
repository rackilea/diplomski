FileInputStream fis = new FileInputStream(new File("E:\\readexcel.xlsx"));
XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sh = wb.getSheetAt(0);
for(Row row : sh) {             
    for(Cell cell : row) {
        System.out.print(cell.getStringCellValue()+"\t");
    }
}
...