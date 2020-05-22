private class MyActionListener implements ActionListener{
  public void actionPerformed(ActionEvent ae) {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(Printer.this);
    boolean doPrint = job.printDialog();
     if( doPrint ) {
       try {
        job.print();
       }  
       catch( PrinterException exc) {
           System.out.println( exc );
       }
     }  
     else {
        System.out.println("You cancelled the print"); 
      } 
    }
}