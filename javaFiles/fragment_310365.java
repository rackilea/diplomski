import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
....
public static void printPDF(String file) {

    FileInputStream psStream = null;
    try {
        psStream = new FileInputStream(file);
    } catch (FileNotFoundException ffne) {
        ffne.printStackTrace();
    }
    if (psStream == null) {
        return;
    }
    DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
    Doc myDoc = new SimpleDoc(psStream, psInFormat, null);
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);

    // this step is necessary because I have several printers configured  
    PrintService myPrinter = null;
    for (int i = 0; i < services.length; i++) {
        String svcName = services[i].toString();
        System.out.println("service found: " + svcName);
        if (svcName.contains("printer closest to me")) {
            myPrinter = services[i];
            System.out.println("my printer found: " + svcName);
            break;
        }
    }
    if (myPrinter != null) {
        DocPrintJob job = myPrinter.createPrintJob();
        try {
            job.print(myDoc, aset);

        } catch (Exception pe) {
            pe.printStackTrace();
        }
    } else {
        System.out.println("no printer services found");
    }
}