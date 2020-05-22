import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class PdfSvg {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document inputDoc =  builder.parse("svg.html");

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();

        ChainingReplacedElementFactory chainingReplacedElementFactory = new ChainingReplacedElementFactory();
        chainingReplacedElementFactory.addReplacedElementFactory(new SVGReplacedElementFactory());
        renderer.getSharedContext().setReplacedElementFactory(chainingReplacedElementFactory);

        renderer.setDocument(inputDoc, "");;
        renderer.layout();
        renderer.createPDF(output);

        OutputStream fos = new FileOutputStream("svg.pdf");
        output.writeTo(fos);
    }
}