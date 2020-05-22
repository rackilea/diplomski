import java.io.*;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;

public class FirstDoc {

    public static void main(String[] args) throws IOException, DocumentException {

        String inputFile = "firstdoc.xhtml";
        String url = new File(inputFile).toURI().toURL().toString();
        String outputFile = "firstdoc.pdf";

        OutputStream os = new FileOutputStream(outputFile);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);

        os.close();

        PdfReader reader = new PdfReader(outputFile);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("firstdocprint.pdf"));
        stamper.setPageAction(PdfWriter.PAGE_OPEN, new PdfAction(PdfAction.PRINTDIALOG), 1); 
        stamper.close();
    }
}