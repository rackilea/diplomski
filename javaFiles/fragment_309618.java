if (rs.isBeforeFirst() == true) {
    while (rs.next()) {
        //writing columns
        if (rs.isFirst()) {
            row = spreadsheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("SR NO");
            cell.setCellStyle(style);
            for (int s = 1; s <= rsmd.getColumnCount(); s++) {
                cell = row.createCell(s);
                cell.setCellValue(rs.getMetaData().getColumnName(+s).toUpperCase());
                cell.setCellStyle(style);
            }
        }
        //Writing data
        row = spreadsheet.createRow(y);
        cell = row.createCell(0);
        cell.setCellValue(y + "");
        //spreadsheet.autoSizeColumn(0);
        for (int x = 1; x <= rsmd.getColumnCount(); x++) {
            cell = row.createCell(x);
            cell.setCellValue(rs.getString(+x));
            //spreadsheet.autoSizeColumn(x);
        }
        y++;
    }

    FileOutputStream out = new FileOutputStream(new File(destination));
    workbook.write(out);
    out.close();
    workbook.dispose();