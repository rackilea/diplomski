import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;


public class ColumnTextExample {


    /** Definition of four columns */
    public static final float[][] COLUMNS = {
        { 36, 36, 224, 579 } , { 230, 36, 418, 579 },
        { 424, 36, 612, 579 } , { 618, 36, 806, 579 }
    };

    public static final String ARTICLE1 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static final String ARTICLE2 = ARTICLE1 + " " + ARTICLE1 + " " + ARTICLE1;
    public static final String ARTICLE3 = ARTICLE1 + " " + ARTICLE1;
public static final String[] ARTICLES = { "HEADER 1\n" + ARTICLE1, "HEADER 2\n" + ARTICLE2, "HEADER 3\n" + ARTICLE3, "HEADER 4\n" + ARTICLE1, "HEADER 5\n" + ARTICLE3 };

    public static void main(String[] args) throws IOException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("columns.pdf"));
        // step 3
        document.open();
        // step 4
        ColumnText ct = new ColumnText(writer.getDirectContent());
        int column = 0;
        ct.setSimpleColumn(
            COLUMNS[column][0], COLUMNS[column][1],
            COLUMNS[column][2], COLUMNS[column][3]);
        int status = ColumnText.START_COLUMN;
        for (String article : ARTICLES) {
            ct.addElement(new Paragraph(article));
            status = ct.go();
            while (ColumnText.hasMoreText(status)) {
                column = nextColumn(document, column, ct);
                status = ct.go();
            }
            column = nextColumn(document, column, ct);
        }
        // step 5
        document.close();
    }

    public static int nextColumn(Document document, int column, ColumnText ct) {
        column = (column + 1) % 4;
        if (column == 0)
            document.newPage();
        ct.setSimpleColumn(
                COLUMNS[column][0], COLUMNS[column][1],
                COLUMNS[column][2], COLUMNS[column][3]);
        return column;
    }
}