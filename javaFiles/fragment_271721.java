for (int i = 0; i < datatypetable.getRowCount(); i++) {
                int ColNum = 0;
                row = wb.createRow(i);
                for (int j = 0; j < datatypetable.getColumnCount(); j++) {
                    cell = wb.getRow(i).getCell(ColNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String item1 = null;
                    if (datatypetable.getValueAt(i, j) != null) {
                        cell.setCellValue(datatypetable.getValueAt(i, j).toString());
                    } else {
                        cell.setCellValue(item1);
                    }
                    ColNum++;
                }


   }