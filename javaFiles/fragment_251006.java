public class CacheableResourceHttpRequestHandler extends ResourceHttpRequestHandler {

        private Map<URL, byte[]> cache = new HashMap<URL, byte[]>();

        @Override
        protected void writeContent(HttpServletResponse response, Resource resource) throws IOException {
            byte[] content = this.cache.get(resource.getURL());
            if (content == null) {
                content = StreamUtils.copyToByteArray(resource.getInputStream());
                this.cache.put(resource.getURL(), content);
            }
            StreamUtils.copy(content, response.getOutputStream());
        }

    }