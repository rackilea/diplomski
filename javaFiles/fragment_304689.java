package biz.hochguertel;

import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextMarkupAnnotation;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredTextEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.ITextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * With the help of the following documentations:
 * - http://developers.itextpdf.com/content/best-itext-questions-stackoverview/content-parsing-extraction-and-redaction-text/itext7-how-read-text-specific-position
 */
public class AppIText {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppIText.class);
    private static int LOG_LEVEL = 0;
    private final static int VISUAL_DEBUG = 100;

    private String filePath = getClass().getClassLoader().getResource("itext/OCA/393-394,549-550_OCA_Java_SE_7_Programmer_I_Certification.pdf").getFile();
    private static String DEST = "demo-output/393-394,549-550_OCA_Java_SE_7_Programmer_I_Certification.pdf";
    private PdfDocument pdfDocument;
    private PdfDocument pdfWriteDoc;


    public void before() throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdir();
        if (file.exists()) {
            file.delete();
        }
        pdfDocument = new PdfDocument(new PdfReader(filePath));
        pdfWriteDoc = new PdfDocument(new PdfWriter(DEST));
    }

    public static void main(String[] args) throws IOException {
        AppIText appIText = new AppIText();
        appIText.before();
        appIText.process();
    }

    private void process() {
        for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
            PdfPage page = pdfDocument.getPage(i);

            List<PdfPage> newPdfPages = pdfDocument.copyPagesTo(i, i, pdfWriteDoc);
            PdfPage newPage = null;
            if (newPdfPages.size() > 0) {
                newPage = newPdfPages.get(0);
            }

            List<PdfAnnotation> annotations = page.getAnnotations();
            for (PdfAnnotation annotation : annotations) {
                if (annotation.getContents() != null) {
                    System.out.println();
                    LOGGER.info("Annotation contents: {}", annotation.getContents());
                    if (annotation instanceof PdfTextMarkupAnnotation) {
                        PdfArray rectangleArray = annotation.getRectangle();
                        LOGGER.info("rectangleArray: x={}, y={}, w={}, h={}",
                                rectangleArray.get(0),
                                rectangleArray.get(1),
                                rectangleArray.get(2),
                                rectangleArray.get(3)
                        );
                        Rectangle pageSizeWithRotation = page.getCropBox();
                        LOGGER.info("pageSizeWithRotation: x={}, y={}, w={}, h={}, top={}, bottom={}, left={}, right={}",
                                pageSizeWithRotation.getX(),
                                pageSizeWithRotation.getY(),
                                pageSizeWithRotation.getWidth(),
                                pageSizeWithRotation.getHeight(),
                                pageSizeWithRotation.getTop(),
                                pageSizeWithRotation.getBottom(),
                                pageSizeWithRotation.getLeft(),
                                pageSizeWithRotation.getRight()
                        );
                        float x = ((PdfNumber) rectangleArray.get(0)).floatValue();
                        float y = ((PdfNumber) rectangleArray.get(1)).floatValue();
                        float width = ((PdfNumber) rectangleArray.get(2)).floatValue() - x;
                        float height = ((PdfNumber) rectangleArray.get(3)).floatValue() - y;
                        Rectangle rectangle = new Rectangle(
                                                                   x,
                                                                   y,
                                                                   width,
                                                                   height
                        );
                        //13:10:33.097 [main] INFO  b.h.AppIText - Annotation contents: q(7.1).explain(1)
                        //13:10:33.107 [main] INFO  b.h.AppIText - rectangleArray: x=90.0338, y=438.245, w=468.33, h=489.749
                        //13:10:33.107 [main] INFO  b.h.AppIText - pageSizeWithRotation: x=0.0, y=0.0, w=531.0, h=666.0, top=666.0, bottom=0.0, left=0.0, right=531.0
                        //width:  468.33f - 90.0388f,
                        //height: 489.749f - 438.245f

                        if (LOG_LEVEL >= VISUAL_DEBUG) {
                            PdfCanvas canvas = new PdfCanvas(newPage);
                            canvas.setFillColor(new DeviceCmyk(1, 0, 0, 0))
                                    .rectangle(rectangle)
                                    .fillStroke();
                        }

                        TextRegionEventFilter regionFilter = new TextRegionEventFilter(rectangle);
                        ITextExtractionStrategy strategy = new FilteredTextEventListener(new LocationTextExtractionStrategy(), regionFilter);
                        String str = PdfTextExtractor.getTextFromPage(page, strategy) + "\n";
                        LOGGER.info("str: {}", str);
                    }
                }
            }
        }
        pdfDocument.close();
        pdfWriteDoc.close();
    }

}