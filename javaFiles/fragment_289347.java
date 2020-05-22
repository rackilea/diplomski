import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.awt.*;

public class CustomPdfExporter extends JRPdfExporter {

    private float previousTop;
    private float previousHeight;
    private float prevY1;
    private float prevY2;

    private static final float FLOAT_ZERO = 0F;

    protected void exportBox(JRLineBox box, JRPrintElement element) {

        if (!isBoxVisible(box)) return;

        pdfContentByte.setLineCap(PdfContentByte.LINE_CAP_PROJECTING_SQUARE);

        float x1 = element.getX() + getOffsetX();
        float y1 = jasperPrint.getPageHeight() - element.getY() - getOffsetY();
        float x2 = element.getX() + getOffsetX() + element.getWidth();
        float y2 = jasperPrint.getPageHeight() - element.getY() - getOffsetY() - element.getHeight();

        Rectangle r = new Rectangle(x1, y2, x2, y1);

        if (previousTop == r.getTop() && previousHeight != r.getHeight()) {
            r.setBottom(prevY2);
        } else {
            prevY2 = y2;
            prevY1 = y1;
            previousHeight = r.getHeight();
            previousTop = r.getTop();
        }

        int borderFlag = 0;

        float lineWidth = 0;
        Color lineColor = null;

        if (box.getLeftPen().getLineWidth().floatValue() > FLOAT_ZERO) {
            borderFlag |= Rectangle.LEFT;
            lineWidth = box.getLeftPen().getLineWidth().floatValue();
            lineColor = box.getLeftPen().getLineColor();
        }

        if (box.getTopPen().getLineWidth().floatValue() > FLOAT_ZERO) {
            borderFlag |= Rectangle.TOP;
            if (lineWidth == 0) {
                lineWidth = box.getTopPen().getLineWidth().floatValue();
                lineColor = box.getTopPen().getLineColor();
            }
        }

        if (box.getRightPen().getLineWidth().floatValue() > FLOAT_ZERO) {
            borderFlag |= Rectangle.RIGHT;
            if (lineWidth == 0) {
                lineWidth = box.getRightPen().getLineWidth().floatValue();
                lineColor = box.getRightPen().getLineColor();
            }
        }

        if (box.getBottomPen().getLineWidth().floatValue() > FLOAT_ZERO) {
            borderFlag |= Rectangle.BOTTOM;
            if (lineWidth == 0) {
                lineWidth = box.getBottomPen().getLineWidth().floatValue();
                lineColor = box.getBottomPen().getLineColor();
            }
        }
        r.setBorder(borderFlag);
        r.setBorderColor(lineColor);
        r.setBorderWidth(lineWidth);

        pdfContentByte.rectangle(r);
        pdfContentByte.stroke();

        pdfContentByte.setLineDash(FLOAT_ZERO);
        pdfContentByte.setLineCap(PdfContentByte.LINE_CAP_ROUND);
    }

    private boolean isBoxVisible(JRLineBox box) {
        return box.getLeftPen().getLineWidth().floatValue() > FLOAT_ZERO
                || box.getTopPen().getLineWidth().floatValue() > FLOAT_ZERO
                || box.getRightPen().getLineWidth().floatValue() > FLOAT_ZERO
                || box.getBottomPen().getLineWidth().floatValue() > FLOAT_ZERO
                ;
    }
}