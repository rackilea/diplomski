import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextMain {
    public static final String DEST = "simple_table4.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        // file.getParentFile().mkdirs();
        new ItextMain().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        document.add(new Paragraph("1-Not aligned with table"));

        document.add(new Chunk());

        Paragraph p = new Paragraph();
        p.setIndentationLeft(20);// (20);

        PdfPTable table = new PdfPTable(4);
        for (int aw = 0; aw < 16; aw++) {
            table.addCell("hi");
        }
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        p.add(table);
        //document.add(table);

        p.add("3- Aligned with table");

        document.add(p);
        document.close();
    }
}