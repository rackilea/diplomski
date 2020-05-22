import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.*;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
        Document pdfDocument = new Document();
        PdfWriter.getInstance(pdfDocument, byteArr);
        pdfDocument.open();
        pdfDocument.add(new Paragraph("Hello World!"));
        pdfDocument.close();

        byte[] byteStream = byteArr.toByteArray();// fetch content in byte array;
        PrintService services = PrintServiceLookup.lookupDefaultPrintService();
        PrinterJob job = PrinterJob.getPrinterJob();
        PDDocument pdDocument = null;
        try {
            pdDocument = PDDocument.load(byteStream);
            job.setPageable(new PDFPageable(pdDocument));
            job.setPrintService(services);
            job.print();
            System.out.println("Done");

        } catch (Exception pe) {
            pe.printStackTrace();

        } finally {
            if (pdDocument != null) {
                pdDocument.close();
            }
        }


    }
}