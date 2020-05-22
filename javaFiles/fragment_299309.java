XSSFRow row2 = sheet.getRow(1);

            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);

            for (int i = 0; i < row2.getLastCellNum(); i++) {// For each cell in the row
                if( row2.getCell(i)!=null){
                row2.getCell(i).setCellStyle(style);// Set the style
                }else{
                    Cell cell=row2.createCell(i);
                    cell.setCellStyle(style);
                }
            }