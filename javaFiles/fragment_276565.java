package so.test1;

import java.io.File;
import java.io.OutputStream;
import javax.xml.transform.stream.StreamSource;
import net.sf.saxon.s9api.XsltTransformer;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;

/**
 *
 * @author dhaley
 *
 */
public class SOTest1 {

    public static void main(String[] args) throws SaxonApiException {
        final String XSLT_PATH = "src/so/test1/json2xml.xsl";
        final String JSON = "{\n" +
                            "    \"color\": \"red\",\n" +
                            "    \"value\": \"#f00\"\n" +
                            "}";

        OutputStream outputStream = System.out;        
        Processor processor = new Processor(false);        
        Serializer serializer = processor.newSerializer();
        serializer.setOutputStream(outputStream);        
        XsltCompiler compiler = processor.newXsltCompiler();
        XsltExecutable executable = compiler.compile(new StreamSource(new File(XSLT_PATH)));        
        XsltTransformer transformer = executable.load();
        transformer.setInitialTemplate(new QName("init")); //<-- SET INITIAL TEMPLATE
        transformer.setParameter(new QName("jsonText"), new XdmAtomicValue(JSON)); //<-- PASS JSON IN AS PARAM
        transformer.setDestination(serializer);
        transformer.transform();

    }

}