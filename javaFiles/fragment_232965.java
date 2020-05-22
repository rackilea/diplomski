FileOutputStream out = new FileOutputStream("dateFormat.xls");
  HSSFWorkbook hssfworkbook = new HSSFWorkbook();
  HSSFSheet sheet = hssfworkbook.createSheet("new sheet");
  HSSFCellStyle cs = hssfworkbook.createCellStyle();
  HSSFDataFormat df = hssfworkbook.createDataFormat();
  HSSFFormulaEvaluator evaluator = new HSSFFormulaEvaluator(hssfworkbook);

  cs.setDataFormat(df.getFormat("h:mm:ss"));
  HSSFRow row = sheet.createRow((short)0);
  HSSFCell cell = row.createCell((short)0);


  cell.setCellFormula("TIME(0,3,24)");//this method only sets the formula string and does not calculate the formula value
  cell.setCellType(Cell.CELL_TYPE_FORMULA);//Set the cells type (numeric, formula or string)

  evaluator.evaluateFormulaCell(cell);// it evaluates the formula, and saves the result of the formula
  cell.setCellStyle(cs);



  HSSFRow row2 = sheet.createRow((short)1);
  HSSFCell cell2 = row2.createCell((short)0);


  cell2.setCellFormula("TIME(0,9,54)");
  cell2.setCellType(Cell.CELL_TYPE_FORMULA);
  evaluator.evaluateFormulaCell(cell2);
  cell2.setCellStyle(cs);