WritableCellFeatures cellFeatures =  null;
        Label checkLabel = null;
        for (int x = 0; x < xlData.size(); x++) {
            for (int i = 0; i <= 14; i++) {
                System.out.println("X:" + x + "I:" + i);
                if (i > 9) {
                   checkLabel = new Label(i, x + xlHeader.size(), (String) arrList.get(0));
                   cellFeatures = new WritableCellFeatures();
                   cellFeatures.setDataValidationList(arrList);
                   checkLabel.setCellFeatures(cellFeatures);
                   writableSheet.addCell(checkLabel);                           
                }
            }
        }
        // All cells modified/added. Now write out the workbook 
        workbook.write();
        workbook.close();