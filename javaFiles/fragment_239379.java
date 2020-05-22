FileInputStream file = new FileInputStream(new File("New Excel with Java"));

//Create a workbook reference
XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheetAt(0);

//Iterate through each rows one by one
Iterator<Row> rowIterator = sheet.iterator();