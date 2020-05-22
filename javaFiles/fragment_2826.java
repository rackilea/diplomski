import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

public class MyPDFTextStripper extends PDFTextStripper
{
    public MyPDFTextStripper() throws IOException
    {
        super();
        // TODO Auto-generated constructor stub
    }

    PDPage currentPage;
    List<PDAnnotation> pageAnnotations;
    private boolean needsEndTag;
    boolean startOfLine = true;

    @Override
    protected void startPage(PDPage page) throws IOException
    {
        currentPage = page;
        pageAnnotations = currentPage.getAnnotations();
        super.startPage(page);
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException
    {
        StringBuilder newText = new StringBuilder();
        PDAnnotation currentAnnot = null;
        for (TextPosition textPosition : textPositions)
        {
            PDAnnotation annotation = getAnnotation(textPosition);
            if (annotation != null)
            {
                if (currentAnnot == null)
                {
                    // if the currentAnnot is null, start a new annotation
                    newText.append("<b id='" + annotation.getAnnotationName() + "'>");
                }
                else if (!currentAnnot.getAnnotationName().equals(annotation.getAnnotationName()))
                {
                    // if the current Annot is different, end it and start a new
                    // one
                    newText.append("</b><b id='" + annotation.getAnnotationName() + "'>");
                }
                // remember this in case the annotation wraps lines
                needsEndTag = true;
                currentAnnot = annotation;
            }
            else if (currentAnnot != null)
            {
                // if no new annotation is associated with the text, but there used to be, close the tag
                newText.append("</b>");
                currentAnnot = null;
                needsEndTag = false;
            }
            newText.append(textPosition.getCharacter());
        }
        super.writeString(newText.toString(), textPositions);
    }

    private PDAnnotation getAnnotation(TextPosition textPosition)
    {
        float textX1 = textPosition.getX();
        // Translate the y coordinate to PDF Space
        float textY1 = currentPage.findMediaBox().getHeight() - textPosition.getY();
        float textX2 = textX1 + textPosition.getWidth();
        float textY2 = textY1 + textPosition.getHeight();

        for (PDAnnotation annotation : pageAnnotations)
        {
            if (annotation.getRectangle().contains(textX1, textY1) && annotation.getRectangle().contains(textX2, textY2))
            {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public String getPageEnd()
    {
        // if the annotation wraps lines and extends to the end of the document, need to add the end tag
        if (needsEndTag)
        {
            return "</b>" + super.getPageEnd();
        }
        return super.getPageEnd();
    }

    public static void main(String[] args) throws Exception
    {
        File file = new File(args[0]);
        PDFParser parser = new PDFParser(new FileInputStream(file));
        parser.parse();
        COSDocument cosDoc = parser.getDocument();

        MyPDFTextStripper pdfStripper = new MyPDFTextStripper();

        PDDocument pdDoc = new PDDocument(cosDoc);
        pdfStripper.setStartPage(0);
        pdfStripper.setEndPage(pdDoc.getNumberOfPages());
        String parsedText = pdfStripper.getText(pdDoc);
        System.out.println(parsedText);
    }
}