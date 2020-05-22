/**
 * Resolves resources from a base URL
 */
public class URLBasedResourceResolver implements LSResourceResolver {

private static final Logger log = LoggerFactory
        .getLogger(URLBasedResourceResolver.class);

private final URI base;

private final Map<URI, String> nsmap;

public URLBasedResourceResolver(URL base, Map<URI, String> nsmap)
        throws URISyntaxException {
    super();
    this.base = base.toURI();
    this.nsmap = nsmap;
}

@Override
public LSInput resolveResource(String type, String namespaceURI,
        String publicId, String systemId, String baseURI) {
    if (log.isDebugEnabled()) {
        String msg = String
                .format("Resolve: type=%s, ns=%s, publicId=%s, systemId=%s, baseUri=%s.",
                        type, namespaceURI, publicId, systemId, baseURI);
        log.debug(msg);
    }
    if (type.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI)) {
        if (namespaceURI != null) {
            try {
                URI ns = new URI(namespaceURI);
                if (nsmap.containsKey(ns))
                    return new MyLSInput(base.resolve(nsmap.get(ns)));
            } catch (URISyntaxException e) {
                // ok
            }
        }
    }
    return null;
}

}