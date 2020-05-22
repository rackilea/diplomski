import java.awt.print.PageFormat;

import java.awt.print.PrinterJob;

public class PrinterSetup 
{

    public static void main(String[] args) throws Exception
    {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = pjob.defaultPage();
        pjob.setPrintable(null, pf);

        if (pjob.printDialog()) {
          pjob.print();
        }
    }
}