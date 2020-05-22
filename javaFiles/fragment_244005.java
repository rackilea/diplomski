@Configuration
public class BaseWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        ResourceResolver resolver = new AdminResourceResolver();
        registry.addResourceHandler("/admin/**")
                .resourceChain(false)
                .addResolver(resolver);


        registry.addResourceHandler("/admin/")
                .resourceChain(false)
                .addResolver(resolver);
    }


    private class AdminResourceResolver implements ResourceResolver {
        private Resource index = new ClassPathResource("/admin/index.html");

        @Override
        public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
            return resolve(requestPath, locations);
        }

        @Override
        public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
            Resource resolvedResource = resolve(resourcePath, locations);
            if (resolvedResource == null) {
                return null;
            }
            try {
                return resolvedResource.getURL().toString();
            } catch (IOException e) {
                return resolvedResource.getFilename();
            }
        }

        private Resource resolve(String requestPath, List<? extends Resource> locations) {

            if(requestPath == null) return null;

            if (!requestPath.startsWith("static")) {
                return index;
            }else{
                return new ClassPathResource("/admin/" + requestPath);
            }
        }
    }
}