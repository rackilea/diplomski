private void addImageToExcelReport(InputStream is, OutputStream os, File image) {
    if (image != null) {
        try {
            Workbook wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);

            InputStream inputStream = new FileInputStream(image);
            byte[] bytes = IOUtils.toByteArray(inputStream);

            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            inputStream.close();

            CreationHelper helper = wb.getCreationHelper();
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setAnchorType(AnchorType.DONT_MOVE_AND_RESIZE);
            sheet.createRow(1).createCell(0);

            anchor.setRow1(0);
            anchor.setRow2(1);
            anchor.setCol1(0);
            anchor.setCol2(1);

            drawing.createPicture(anchor, pictureIdx);

            wb.write(os);
            wb.close();

        } catch (IOException e) {
            loggerService.traceError(e.getMessage(), e);
        }
    }
}