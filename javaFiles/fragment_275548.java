WritableCellFeatures cellFeatures =  null;
        Blank b = null;
        for (int x = 0; x < xlData.size(); x++) {
            for (int i = 0; i <= 14; i++) {
                System.out.println("X:" + x + "I:" + i);
                if (i > 9) {
                   b = new Blank(i, x + xlHeader.size());
                   cellFeatures = new WritableCellFeatures();
                   cellFeatures.setDataValidationList(arrList);
                   b.setCellFeatures(cellFeatures);
                   writableSheet.addCell(b);                           
                }
            }
        }
        // All cells modified/added. Now write out the workbook 
        workbook.write();
        workbook.close();