import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import net.sf.saxon.TransformerFactoryImpl;
import net.sf.saxon.s9api.ExtensionFunction;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.jaxp.SaxonTransformerFactory;
import location.to.test.java.file.Test;

public class TestMain {
    public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {

        TransformerFactory factory = TransformerFactory.newInstance();

        // Grab the handle of Transformer factory and cast it to TransformerFactoryImpl
        TransformerFactoryImpl tFactoryImpl = (TransformerFactoryImpl) factory;

        // Get the currently used processor
        net.sf.saxon.Configuration saxonConfig = tFactoryImpl.getConfiguration();
        Processor processor = (Processor) saxonConfig.getProcessor();

        // Here extension happens, test comes from class Test -> Test.java
        ExtensionFunction test = new Test();
        processor.registerExtensionFunction(test);

        Source xslt = new StreamSource(new File("test.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File("input.xml"));
        transformer.transform(text, new StreamResult(new File("result.xml")));
    }
}