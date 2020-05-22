Workbook workbook;
....
workbook = excelExportDAO.createLoanOffersXls(loanOffersDTOs);
if (workbook != null) {
    if (workbook instanceof HSSFWorkbook) {
       response.setContentType("application/vnd.ms-excel");
       response.setHeader("Content-Disposition",
                                "attachment; filename=report.xls");
    } else {
       response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
       response.setHeader("Content-Disposition",
                                "attachment; filename=report.xlsx");
    }
    OutputStream out = response.getOutputStream();
    hssfWorkbook.write(out);    
    out.close();
}