import java.io.StringWriter;
import java.util.Map;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import net.sf.saxon.lib.OutputURIResolver;

public class HashMapSaverOutputUriResolver implements OutputURIResolver{
    private Map<String, String> results; // We save here
    public HashMapSaverOutputUriResolver(Map<String, String> map){
        this.results = map; // Set map
    }
    public OutputURIResolver newInstance() {
        return this;
    }
    public Result resolve(String href, String base) throws TransformerException { // We set to resolve the file to write to a stringResult that wraps a stringWritter
        StringWriter sw = new StringWriter(); // StringWritter 
        StreamResult sr = new StreamResult(sw); // StreamResult
        sr.setSystemId(href); // Id of the streamResult = href = fileName
        return sr;
    }
    public void close(Result result) throws TransformerException { // End of result:document transformed
        StreamResult sr = (StreamResult) result; // Get StreamResult
        StringWriter sw = (StringWriter) sr.getWriter(); // Get StreamWritter
        String href = sr.getSystemId(); // Get href (fileName)
        String content = sw.toString(); // Get string file-content
        this.results.put(href, content); // Save in map
    }
}