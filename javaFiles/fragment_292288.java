Workbook workbook = Workbook.getWorkbook(new File("/path/to/protected.xls"));
workbook.setProtected(false);
WritableWorkbook copy = Workbook.createWorkbook(new File("/path/to/unprotected.xls"), workbook);
WritableSheet[] sheets = copy.getSheets();

for (WritableSheet sheet : sheets){
    sheet.getSettings().setProtected(false);
}

copy.write();
copy.close();