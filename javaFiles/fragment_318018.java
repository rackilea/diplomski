public void createExcelFile(final HttpServletResponse response) {
    XSSFWorkbook xssfWorkbook = null;
    try {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" file.xlsx");

        xssfWorkbook = new XSSFWorkbook();
        final XSSFSheet sheet = xssfWorkbook.createSheet("sheet1");

        writeExcelOutputData(//WRITE DATA TO FILE/SHEET/CELLS);

        xssfWorkbook.write(response.getOutputStream());
        xssfWorkbook.close();
    } catch (final Exception e) {
        LOGGER.error("File not created for download"));
    }
}