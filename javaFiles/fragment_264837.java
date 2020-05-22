53 public class More ...SystemDefaultRoutePlanner extends DefaultRoutePlanner {
54 
55     private final ProxySelector proxySelector;
56 
57     public More ...SystemDefaultRoutePlanner(
58             final SchemePortResolver schemePortResolver,
59             final ProxySelector proxySelector) {
60         super(schemePortResolver);
         /*
           proxySelector ARE NULL AND ProxySelector.getDefault(); 
           RETURNS ALSO NULL DUE THAT SOAPUI PROBABLY MAKE BEFORE
           ProxySelect.setDefault(null);
         */
61         this.proxySelector = proxySelector != null ? proxySelector : ProxySelector.getDefault();
62     }
63 
64     public More ...SystemDefaultRoutePlanner(final ProxySelector proxySelector) {
65         this(null, proxySelector);
66     }
67 
68     @Override
69     protected HttpHost More ...determineProxy(
70             final HttpHost    target,
71             final HttpRequest request,
72             final HttpContext context) throws HttpException {
73         final URI targetURI;
74         try {
75             targetURI = new URI(target.toURI());
76         } catch (final URISyntaxException ex) {
77             throw new HttpException("Cannot convert host to URI: " + target, ex);
78         }
           /* HERE IS THE NULLPOINTER */
79         final List<Proxy> proxies = this.proxySelector.select(targetURI);