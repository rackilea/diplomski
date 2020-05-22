@Provider
@PreMatching
@Priority(3000)
public static class QueryConnegFilter implements ContainerRequestFilter {

    private static final Map<String, String> mappings;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("xml", MediaType.APPLICATION_XML);
        map.put("json", MediaType.APPLICATION_JSON);
        mappings = Collections.unmodifiableMap(map);
    }

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        final String format = request.getUriInfo().getQueryParameters().getFirst("format");
        if (format != null) {
            final String mediaType = mappings.get(format);
            if (mediaType != null) {
                request.getHeaders().putSingle(HttpHeaders.ACCEPT, mediaType);
            }
        }
    }
}