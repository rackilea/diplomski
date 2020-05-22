OPCPackage pkg = OPCPackage.open("existingFile.xlsx");
XSSFWorkbook wb = (XSSFWorkbook) WorkbookFactory.create(pkg);

// make your modifications... 
XSSFSheet sheet = wb.getSheetAt(0);
//
XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
ByteArrayOutputStream os = new ByteArrayOutputStream();
wb.write(os);
pkg.close();
os.close();
Faces.sendFile(os.toByteArray(), "file.xlsx", true);