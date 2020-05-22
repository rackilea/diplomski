import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class PdfExtractor {
    private static Logger logger = LoggerFactory.getLogger(PdfExtractor.class);

    public static void main(String args[]) throws Exception {
        StopWatch sw = new StopWatch();
        List<String> files = new ArrayList<>();
        files.add("C:/Users/m/Downloads/20170115.pdf");
        files.add("C:/Users/m/Downloads/20170215.pdf");
        files.add("C:/Users/m/Downloads/20170315.pdf");
        files.add("C:/Users/m/Downloads/20170415.pdf");
        files.add("C:/Users/m/Downloads/20170515.pdf");
        files.add("C:/Users/m/Downloads/20170615.pdf");
        files.add("C:/Users/m/Downloads/20170715.pdf");
        files.add("C:/Users/m/Downloads/20170815.pdf");
        files.add("C:/Users/m/Downloads/20170915.pdf");
        files.add("C:/Users/m/Downloads/20171015.pdf");
        files.add("C:/Users/m/Downloads/20171115.pdf");
        files.add("C:/Users/m/Downloads/20171215.pdf");
        files.add("C:/Users/m/Downloads/20180115.pdf");
        InputStream is;
        List<ChasePdfParser.ChaseRecord> full = new ArrayList<>();
        for (String fileName : files) {
            logger.info("Now processing " + fileName);
            is = new FileInputStream(fileName);
            ContentHandler contenthandler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(is, contenthandler, metadata, new ParseContext());
            String data = contenthandler.toString();
            List<ChasePdfParser.ChaseRecord> chaseRecords = ChasePdfParser.parse(data);
            full.addAll(chaseRecords);
            is.close();
        }
        logger.info("Total processing time: " + PrettyPrinter.toMsSoundsGood(sw.getTime()));
        full.forEach(cr -> System.err.println(cr.date + "|" + cr.desc + "|" + cr.amt));
    }
}