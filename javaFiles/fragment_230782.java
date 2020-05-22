import java.io.File;
import org.apache.tika.Tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.Tika;

import org.xml.sax.SAXException;

public class Test {
    public static void main(final String[] args) {
        //Your way
        try {
            File file = new File("Example.pdf");
            String content = new Tika().parseToString(file);
            System.out.println("The Content: " + content);
        } catch (final Exception e) {
            e.printStackTrace();
        }

        //Another way
        try {
            System.out.println("The contents:\t[" + Test.tikaPdfTest("Example.pdf") + "]");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static String tikaPdfTest(final String fileName) throws IOException, SAXException, TikaException {
        try(final FileInputStream inputstream = new FileInputStream(new File(fileName))) {
            final BodyContentHandler handler = new BodyContentHandler();
            new PDFParser().parse(inputstream, handler, new Metadata(), new ParseContext());
            return handler.toString().trim();
        }
    }
}