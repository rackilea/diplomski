for (String s : e.getValue()) { 
        if ((row - 5) < (e.getValue().size())) {
            valueRow = worksheet.createRow(row += 1);
            valueRow.createCell(keyCell).setCellValue(s);
            } else {
                valueRow.createCell(keyCell).setCellValue(s);
            }
        }