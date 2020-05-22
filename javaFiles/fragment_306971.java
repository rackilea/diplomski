void CreateDir(String xlsPath) throws IOException {
  ChooseFileClass cf = new ChooseFileClass();
  ChooseWorkSpace ws = new ChooseWorkSpace();
  Cell cell;

  try {
     Workbook workbook = new XSSFWorkbook(new FileInputStream(xlsPath));
     Sheet sheet = workbook.getSheetAt(0);

     for (int i = 0; i < N; i++) {  /* use N Since you know the number of rows */
        cell = sheet.getCell(3,i);  /* Assuming column C corresponds to 3rd column */
        cell.setCellType(Cell.CELL_TYPE_STRING);
        System.out.print(cell.getStringCellValue() + "\t");
        String folder = cell.getStringCellValue();
        File file = new File(STATIC_DIRECTORY + DELIMITER + folder);
        if (!file.exists()) {
           if (file.mkdir()) {
           // directory created
           } 
           else {
              System.err.println("Directory generation failed");
           }
        }

        System.out.println();
     }
  } 
  catch (FileNotFoundException e) {
     e.printStackTrace();
  } 
  catch (IOException e) {
     e.printStackTrace();
  }

}