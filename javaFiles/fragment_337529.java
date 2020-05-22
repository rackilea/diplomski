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
        final String XSLT_PATH = "src/so/test1/test.xsl";
        final String JSON = "{\"playerStats\": [\n" +
                             "    {\"jerseyNumber\": \"23\", \"fgPercentage\": 60, \"plusMinus\": \"plus\"},\n" +
                             "    {\"jerseyNumber\": \"24\", \"fgPercentage\": 40, \"plusMinus\": \"minus\"}\n" +
                             "]}";

        OutputStream outputStream = System.out;        
        Processor processor = new Processor(false);        
        Serializer serializer = processor.newSerializer();
        serializer.setOutputStream(outputStream);        
        XsltCompiler compiler = processor.newXsltCompiler();
        XsltExecutable executable = compiler.compile(new StreamSource(new File(XSLT_PATH)));        
        XsltTransformer transformer = executable.load();
        transformer.setInitialTemplate(new QName("init")); //<-- SET INITIAL TEMPLATE
        transformer.setParameter(new QName("json"), new XdmAtomicValue(JSON)); //<-- PASS JSON IN AS PARAM
        transformer.setDestination(serializer);
        transformer.transform();
    }

}