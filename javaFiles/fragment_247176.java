row=spreadsheet.createRow(r); 
            cell1 = row.createCell(c);
            cell1.setCellValue(list.get(i).getSno());
            cell1 = row.createCell(++c); // or however you want to track the column index
            cell1.setCellValue(list.get(i).getQsemail());
            cell1 = row.createCell(++c);
            ... and so on