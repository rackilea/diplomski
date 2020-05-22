for(int j=2; j<7; j++)
            {
            row = sheet.getRow(j - 1);
            if(row==null)
                row = sheet.createRow(j - 1);

            cell = row.getCell(col_Num);
            //it will check if cell contains no value then create cell and set value                    
            if(cell == null)
            {
                cell = row.createCell(col_Num);
                cell.setCellValue(value);
                break;
            }

            }