document.open(); 

             PdfPTable mainTable = new PdfPTable(2);
             mainTable.setWidths(new int[] { 10,90 });

             PdfPCell innerCellKeyName = new PdfPCell(new Phrase("Name", boldFont));
             //innerCellKeyName.setBorder(Rectangle.NO_BORDER);
             mainTable.addCell(innerCellKeyName);

             // step4 
             PdfPTable table = new PdfPTable(3); 
             PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3")); 
             cell.setColspan(3); 
             table.addCell(cell); 
             table.addCell("1.1"); 
             table.addCell("2.1"); 
             table.addCell("3.1"); 
             table.addCell("1.2"); 
             table.addCell("2.2"); 
             table.addCell("3.2"); 
             table.addCell("4.1"); 
             table.addCell("4.2"); 
             table.addCell("4.3"); 



             PdfPCell cell2 = new PdfPCell(table);
             mainTable.addCell(cell2);
             document.add(mainTable); 


             PdfPTable mainTable2 = new PdfPTable(2);
             mainTable2.setWidths(new int[] { 10,90 });

             PdfPCell innerCellKeyName2 = new PdfPCell(new Phrase("", boldFont));

             innerCellKeyName2.setBorder(Rectangle.NO_BORDER);
             mainTable2.addCell(innerCellKeyName2);

             // step4 
             PdfPTable table2 = new PdfPTable(3); 
             PdfPCell cell3 = new PdfPCell(new Paragraph("header with colspan 3")); 
             cell3.setColspan(3); 
             table2.addCell(cell3); 
             table2.addCell("1.1"); 
             table2.addCell("2.1"); 
             table2.addCell("3.1"); 
             table2.addCell("1.2"); 
             table2.addCell("2.2"); 
             table2.addCell("3.2"); 
             table2.addCell("4.1"); 
             table2.addCell("4.2"); 
             table2.addCell("4.3"); 



             PdfPCell cell4 = new PdfPCell(table2);
             mainTable2.addCell(cell4);


             document.add(mainTable2);