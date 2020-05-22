XSSFWorkbook wb = new XSSFWorkbook(); 
XSSFSheet sheet = wb.createSheet("SomeSheet");

Row row = sheet.createRow(0);
Cell cell = row.createCell(0);
XSSFDataValidationHelper dvHelper = new SSFDataValidationHelper(sheet);

XSSFDataValidationConstraint dvConstraint = 
    (XSSFDataValidationConstraint)
    dvHelper.createNumericConstraint(
        XSSFDataValidationConstraint.ValidationType.DECIMAL,
        XSSFDataValidationConstraint.OperatorType.BETWEEN,
        String.valueOf(Float.MIN_VALUE),
        String.valueOf(Float.MAX_VALUE)
    );

// Cell range is important here. 
CellRangeAddressList addressList = new CellRangeAddressList(
        0, 2, 1, 3);
// 0 - starting row, 2 - ending row
// 1 - starting col, 3 - ending col

XSSFDataValidation validation =(XSSFDataValidation)dvHelper.createValidation(
        dvConstraint, addressList);
validation.setSuppressDropDownArrow(false);
validation.setShowErrorBox(true);

CellStyle style = wb.createCellStyle();
style.setAlignment(CellStyle.ALIGN_LEFT);
cell.setCellStyle(style);

sheet.addValidationData(validation);

cell.setCellValue(20);