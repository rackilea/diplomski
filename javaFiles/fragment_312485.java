FileInputStream file = new FileInputStream(new File("C:\\Users\\SomeExcel.xlsx"));

// Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheetAt(0);

SomePojo somePojo = new SomePojo();

Map<Object, Object> x = new LinkedHashMap<>();
// ignoring header for that I've +1 in loop
for(int i = sheet.getFirstRowNum() + 1; i<=sheet.getLastRowNum(); i++)
{

    Row row = sheet.getRow(i);
    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
        Cell ce = row.getCell(j);
        if (j == 0) {
            // If you have Header in text It'll throw exception because it won't get
            // NumericValue
            somePojo.setName(ce.getStringCellValue());
        }
        if (j == 1) {
            somePojo.setValue(ce.getStringCellValue());
        }
        // Same for third column
    }
    x.put(somePojo.getName(), somePojo.getValue());
}

// Object to JSON in String
ObjectMapper mapper = new ObjectMapper();
// Object to JSON in file
mapper.writeValue(new File("C:\\some.json"),x);
// Print in console
String jsonFromMap = mapper.writeValueAsString(x);
file.close();