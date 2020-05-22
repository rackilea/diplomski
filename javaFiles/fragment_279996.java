WritableWorkbook book = Workbook.createWorkbook(new File("output.xls"));
            WritableSheet sheet = book.createSheet("Some Sheet", 0);

            Label label = new Label(1, 2, "Some label"); 
            sheet.addCell(label); // add cell!

            WritableCellFeatures wcf = new WritableCellFeatures();
            wcf.setComment("Hello!");

            // set cell features!
            label.setCellFeatures(wcf);

            book.write();
            book.close();