//create the first row
    Row row = sheet.createRow((short) l);
    while (i < L+1) {
        Cell cell = row.createCell((short) c);
        cell.setCellValue(i+1);
        sheet.addMergedRegion(new CellRangeAddress(l, l + 9, c, c + 2));

        //this adds the border
        CellRangeAddress cellRangeAddress = new CellRangeAddress(l, l + 9 , c, c + 2);
        HSSFRegionUtil.setBorderTop(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);
        HSSFRegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);
        HSSFRegionUtil.setBorderRight(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);
        HSSFRegionUtil.setBorderBottom(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);

        cell.setCellStyle(createBorderedStyle(wb));
        if (c>=5){
            c=0;
            l=l+10;
            //go to the next row here
            row = sheet.createRow((short) l);
        }else {
            c=c+3;
        }
        i++;
    }