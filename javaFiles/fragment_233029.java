import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;


public class test {

    public static void main(String[] args) throws FOPException, TransformerException, IOException 
    {
    /*..*/

     // Step 1: Construct a FopFactory
     // (reuse if you plan to render multiple documents!)
     FopFactory fopFactory = FopFactory.newInstance();

     // Step 2: Set up output stream.
     // Note: Using BufferedOutputStream for performance reasons (helpful with FileOutputStreams).
     OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("F:/myfile.pdf")));

     try 
     {
        // Step 3: Construct fop with desired output format
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

        // Step 5: Setup input and output for XSLT transformation
        // Setup input stream

        Source xsltSource = new StreamSource(new File("F:/myfile.xsl"));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(xsltSource);

        int[] array = {1,2,3};
        transformer.setParameter("test", "1234");
        transformer.setParameter("testRaw", array);

        // Resulting SAX events (the generated FO) must be piped through to FOP
        Result res = new SAXResult(fop.getDefaultHandler());

        transformer.transform(xsltSource, res);

     } 
     finally 
     {
         out.close();
     }
    }

}