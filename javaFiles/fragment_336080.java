@RequestMapping(value="generateRemit")
protected View remitExcel( @RequestParam("date") String date)
{
    final String finalDate = date;
    return new AbstractExcelView() {
        @Override
        protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {
                response.addHeader("Content-Disposition", "attachment; filename=\""+finalDate+"Disney Remittance Final\"");

                HashMap<String,List> items = jdbcBillingDao.getWeeklyRemit(finalDate);

             HSSFSheet sheet = workbook.createSheet("Final Remittance");

             @SuppressWarnings("unchecked")
            List<ItemView> remit = items.get("remit");

            Row header = sheet.createRow(0);
            Cell cell1 = header.createCell(0);
            cell1.setCellValue("DISNEY INVOICE NUM");
            Cell cell2 = header.createCell(1);
            cell2.setCellValue("EBI AMOUNT");
            Cell cell3 = header.createCell(2);
            cell3.setCellValue("PAYING AMOUNT");
            Cell cell4 = header.createCell(3);
            cell4.setCellValue("RESIDUAL AMOUNT");
            Cell cell5 = header.createCell(4);
            cell5.setCellValue("BOOKING #");
            Cell cell6 = header.createCell(5);
            cell6.setCellValue("GUEST NAME");
            Cell cell7 = header.createCell(6);
            cell7.setCellValue("NOTES/Dispute Reason");
                          //more spreadsheet generation
        }


      };