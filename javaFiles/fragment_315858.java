import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import org.apache.tika.metadata.Property;

public class TestTika {

    public static void main(String[] args) {
        File file = null;
    InputStream stream = null;
        String contentType = null;

        try
        {
            file = new File("C:\\tmp\\test3_iamexe.txt");
            stream = new FileInputStream(file);

            AutoDetectParser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();

            try {
                // This step here is a little expensive
                parser.parse(stream, handler, metadata);
            } finally {
                stream.close();
            }

            // metadata is a HashMap, you can loop over it see what you need. Alternatively, I think Content-Type is what you need
            contentType = metadata.get("Content-Type");

        } catch(...)
        {
            // handle it
        }

        return;
    }
}