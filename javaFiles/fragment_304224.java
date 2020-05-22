String fileName = "MyFile.xls"; //Your file name here.

response.setContentType("application/vnd.ms-excel"); //Tell the browser to expect an excel file
response.setHeader("Content-Disposition", "attachment; filename="+fileName); //Tell the browser it should be named as the custom file name

HSSFWorkbook workbook = createExcel();
workbook.write(response.getOutputStream());