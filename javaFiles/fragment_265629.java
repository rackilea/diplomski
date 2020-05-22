import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class PrintPDF
{

    private static final String PASSWORD     = "-password";
    private static final String SILENT       = "-silentPrint";
    private static final String PRINTER_NAME = "-printerName";

    /**
     * private constructor.
     */
    private PrintPDF()
    {
        //static class
    }


    public static void main( String pdfFilepath,String printerindx ) throws Exception
    {
        String password = "";
        String pdfFile = pdfFilepath;
        boolean silentPrint = true;

        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();            


        if( pdfFile == null )
        {
            usage();
        }

        PDDocument document = null;
        try
        {
            document = PDDocument.load( pdfFile );

            if( document.isEncrypted() )
            {
                document.decrypt( password );
            }
            PrinterJob printJob = PrinterJob.getPrinterJob();

            if(printerindx != null )
            {
                PrintService[] printService = PrinterJob.lookupPrintServices();

                printJob.setPrintService(printService[Integer.parseInt(printerindx)]);


            }
            txt=new PDDocument(document);
            if( silentPrint )
            {


                document.silentPrint( printJob );
            }
            else
            {
                document.print( printJob );
            }
        }
        finally
        {
            if( document != null )
            {
                document.close();
            }
        }
    }

    /**
     * This will print the usage requirements and exit.
     */
    private static void usage()
    {
        System.err.println( "Usage: java org.apache.pdfbox.PrintPDF [OPTIONS] <PDF file>\n" +
                "  -password  <password>        Password to decrypt document\n" +
                "  -silentPrint                 Print without prompting for printer info\n"
        );
        System.exit( 1 );
    }
}