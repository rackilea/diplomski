public class DuplicateFormParamsFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ContainerRequest cr = (ContainerRequest) requestContext;
        cr.bufferEntity();
        Form form = cr.readEntity(Form.class);
        MultivaluedMap<String, String> asMap = form.asMap();
        for (String key: asMap.keySet()) {
            if (asMap.get(key).size() > 1) {
                throw new BadRequestException("Duplicate param: " + key);
            }
        }
    }
}