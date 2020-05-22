import java.util.concurrent.ConcurrentMap;
import org.restlet.data.Form;
import org.restlet.engine.header.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;


...

clientResource = new ClientResource("http://someurl.com");
ConcurrentMap<String, Object> attrs = clientResource.getRequest().getAttributes();
Series<Header> headers = (Series<Header>) attrs.get(HeaderConstants.ATTRIBUTE_HEADERS);
if (headers == null) {
    headers = new Series<Header>(Header.class);
    Series<Header> prev = (Series<Header>) 
        attrs.putIfAbsent(HeaderConstants.ATTRIBUTE_HEADERS, headers);
    if (prev != null) { headers = prev; }
}
headers.add("myHeaderName", "myHeaderValue");