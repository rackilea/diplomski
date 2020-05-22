public void invoice_job()   
   {



    try 
    {

      int rows=JTable.getRowCount();
      String head = String.format("%30s\n\n", "   Invoice Reciept   ");
      String s = String.format("%-15s %5s %10s\n", "Item",        "Qty",        "Price");
      String s1 = String.format("%-15s %5s %10s\n","---------","--------"," ----------");    
      String output = head + s + s1;
      for(int row = 0; row<rows; row++)

      {   

         String Names = (String)JTable.getValueAt(row, 0);
         String Quanti = (String)JTable.getValueAt(row, 1);
         String Prices = (Double)JTable.getValueAt(row, 2);

         String line = String.format("%-15s %5s %10.2f\n",Names,Quanti,Prices);  
         output += line;
         String lin2 = String.format("%-15s\n","-------------------------------------");
         output += lin2;



       }

       String Total = String.format("%37s\n","Total");
       String total = String.format("%37s\n\n",lbl.getText()); 
       String footer = String.format("%-15s\n", "Meridon sweets and bakers\nSince 1987\nPoint of sale system\nPowered by msofttech\nwww.msofttech.net");
       output += Total + total + footer;
       textPane.setText(output);

       JOptionPane.showMessageDialog(null, output);


       PrinterJob printerJob = PrinterJob.getPrinterJob();
       PageFormat pageFormat = printerJob.defaultPage();
       Paper paper = new Paper();
       paper.setSize(180.0, (double) (paper.getHeight() + rows * 10.0));
       paper.setImageableArea(rows, rows, paper.getWidth() - rows * 2, paper.getHeight() - rows * 2);
       pageFormat.setPaper(paper);
       pageFormat.setOrientation(PageFormat.PORTRAIT);
       printerJob.setPrintable(textPane.getPrintable(null, null), pageFormat);
       printerJob.print();

    } 
    catch ( Exception e ) 
    {

        e.printStackTrace();
    }
}