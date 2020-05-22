public void printPage() throws PrinterException
        {
            PrinterJob job = PrinterJob.getPrinterJob();
            boolean ok = job.printDialog();
            if (ok) {
                job.setJobName("TEST JOB");
                job.setPrintable(this);
                job.print();
            }
        }