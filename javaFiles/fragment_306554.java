import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UriAdapter extends XmlAdapter<String, URI> {

    public URI unmarshal(String s) {
        if(s != null){
            try {
                return new URI(s.replace(" ", "%20"));
            } catch (URISyntaxException e) {
            }
        }
        return null;
    }

    public String marshal(URI uri) {
        return uri.getPath();
    }
}