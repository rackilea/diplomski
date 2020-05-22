//Using workbook
XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("abc.xlsx")));
//Getting first sheet
XSSFSheet sheet = workbook.getSheetAt(0);
//Checking A1 cell that strikethrough or not
boolean strikeOutStatus=sheet.getRow(0).getCell(0).getCellStyle().getFont().getStrikeout();
System.out.println(strikeOutStatus);