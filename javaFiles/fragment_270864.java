@Singleton
public class ViewFilter implements Filter {
    private @Inject Provider<ViewBeanPropertyFilter> filter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ObjectWriterInjector.set(new ObjectWriterModifier() {
            @Override
            public ObjectWriter modify(EndpointConfigBase<?> endpoint, MultivaluedMap<String, Object> responseHeaders, Object valueToWrite, ObjectWriter w, JsonGenerator g) throws IOException {
                return w.with(new FilterProvider() {
                    @Override
                    public BeanPropertyFilter findFilter(Object filterId) {
                        if(filterId.equals(ViewFilterJacksonModule.FILTER_NAME)) {
                            return filter.get();
                        }
                        return null;
                    }
                });
            }
        });
        chain.doFilter(request, response);
    }

    public static class ViewBeanPropertyFilter extends SimpleBeanPropertyFilter {
        private @Inject ViewManager manager;

        @Override
        protected boolean include(BeanPropertyWriter writer) {
            Class<?> cls = writer.getMember().getDeclaringClass();
            return manager.isFieldInView(cls, writer.getMember().getName());
        }

        @Override
        protected boolean include(PropertyWriter writer) {
            return true;
        }
    }
}