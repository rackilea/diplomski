import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.filter.UriConnegFilter;

@PreMatching
@Priority(3000)
public class MyUriConnegFilter extends UriConnegFilter {

    public MyUriConnegFilter(@Context Configuration config) {
        super(config);
    }

    public MyUriConnegFilter(Map<String, MediaType> mediaTypeMappings, 
                             Map<String, String> languageMappings) {
        super(mediaTypeMappings, languageMappings);
    }

    @Override
    public void filter(ContainerRequestContext rc)
            throws IOException {
        UriInfo uriInfo = rc.getUriInfo();

        String path = uriInfo.getRequestUri().getRawPath();
        if (path.indexOf('.') == -1) {
            return;
        }
        List<PathSegment> l = uriInfo.getPathSegments(false);
        if (l.isEmpty()) {
            return;
        }
        PathSegment segment = null;
        for (int i = l.size() - 1; i >= 0; i--) {
            segment = (PathSegment) l.get(i);
            if (segment.getPath().length() > 0) {
                break;
            }
        }
        if (segment == null) {
            return;
        }
        int length = path.length();

        String[] suffixes = segment.getPath().split("\\.");
        for (int i = suffixes.length - 1; i >= 1; i--) {
            String suffix = suffixes[i];
            if (suffix.length() != 0) {
                MediaType accept = (MediaType) this.mediaTypeMappings.get(suffix);
                if (accept != null) {
                    rc.getHeaders().putSingle("Accept", accept.toString());

                    int index = path.lastIndexOf('.' + suffix);
                    path = new StringBuilder(path).delete(index, index + suffix.length() + 1).toString();
                    suffixes[i] = "";
                    break;
                }
            }
        }
        for (int i = suffixes.length - 1; i >= 1; i--) {
            String suffix = suffixes[i];
            if (suffix.length() != 0) {
                String acceptLanguage = (String) this.languageMappings.get(suffix);
                if (acceptLanguage != null) {
                    rc.getHeaders().putSingle("Accept-Language", acceptLanguage);

                    int index = path.lastIndexOf('.' + suffix);
                    path = new StringBuilder(path).delete(index, index + suffix.length() + 1).toString();
                    suffixes[i] = "";
                    break;
                }
            }
        }
        if (length != path.length()) {
            //rc.setRequestUri(uriInfo.getRequestUriBuilder().replacePath(path).build(new Object[0]));
        }
    }
}