PrinterJob pjob = PrinterJob.getPrinterJob();
           PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
           PageFormat pfDefault = pjob.pageDialog(aset);
           pjob.setJobName(file.getName());
           pages.show(pjob);
           if (pjob.printDialog(aset)) {
              pfDefault = pjob.validatePage(pfDefault);
              Book book = new Book();
              book.append(pages, pfDefault, pdfFile.getNumPages());
              pjob.setPageable(book);
              try {

                 pjob.print(aset);

              }
              catch (PrinterException exc) {
                 System.out.println(exc);
              }