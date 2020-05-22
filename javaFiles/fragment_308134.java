import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;
import java.text.*;
import javax.print.attribute.standard.*;

public class ShowPrinters {

    public ShowPrinters() {
    }

    public static void main(String[] args) {
        DocFlavor myFormat = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PrintService[] services =PrintServiceLookup.lookupPrintServices(myFormat, aset);
        System.out.println("The following printers are available");
        for (int i=0;i<services.length;i++) {
            System.out.println("  service name: "+services[i].getName());
        }
    }
}