InputStream is = file.getInputStream();
    OutputStream os = response.outputStream;

    String fileName = "desiredFilename." + ext

    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "Attachment;Filename=${fileName}");
    try {

        PoiTransformer transformer = PoiTransformer.createTransformer(is, os);
        org.apache.poi.ss.usermodel.Workbook workbook = transformer.getWorkbook()
        Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex())
        int lastColNum = sheet.getRow(0).getLastCellNum()

        Cell cell;

        cell = sheet.getRow(0).getCell(lastColNum);
        if(cell==null){
            cell = sheet.getRow(0).createCell(lastColNum);
        }
        cell.setCellType(1)
        cell.setCellValue("Message")
        cell.setCellStyle(getStyle(workbook, 2))

        for(int it=1; it<sheet.getLastRowNum(); it++) {
            if (message.get(new Long(it))!=null && message.get(new Long(it))!=[]) {
                cell = sheet.getRow(it).getCell(lastColNum);
                if(cell==null){
                    cell = sheet.getRow(it).createCell(lastColNum);
                }
                cell.setCellType(1)
                cell.setCellValue(message.get(new Long(it)).join(', '))
                cell.setCellStyle(getStyle(workbook, 1))
            }
        }

        sheet.autoSizeColumn(lastColNum);
        transformer.write();