int lastRow = sheets.getLastRowNum() + 1;    
for (int i=1; i<=lastRow; i++){
        XSSFRow currentRow = sheets.getRow(i); 
        if (currentRow != null && currentRow.getCell(0) != null) {
                    chooseRowComboBox.addItem(String.valueOf(i));
                }
            }