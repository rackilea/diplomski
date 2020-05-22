Cell cell1 = row.createCell(c);
            cell1.setCellValue(list.get(i).getSno());
            Cell cell2 = row.createCell(++c);
            cell2.setCellValue(list.get(i).getQsemail());
            Cell cell3 = row.createCell(++c);
            ...