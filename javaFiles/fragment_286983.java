public class MultipartConfigurationContext {

    private static ThreadLocal<Integer> maxFileSize = new ThreadLocal<>();

    public static void setMaxFileSize(Integer val) {
        maxFileSize.set(val);
    }

    public static Integer getMaxFileSize() {
        return maxFileSize.get();
    }

    public static void clear() {
        maxFileSize.set(null);
    }
}

public class UpdatableMultipartConfigElement extends MultipartConfigElement {

    private final long maxFileSize;

    public UpdatableMultipartConfigElement(String location, long maxFileSize, long maxRequestSize, int fileSizeThreshold) {
        super(location, maxFileSize, maxRequestSize, fileSizeThreshold);
        this.maxFileSize = maxFileSize;
    }

    @Override
    public long getMaxFileSize() {
        return MultipartConfigurationContext.getMaxFileSize() == null
                ? maxFileSize : MultipartConfigurationContext.getMaxFileSize();
    }
}

public class UpdateMultipartConfigurationFilter extends OncePerRequestFilter implements Ordered {

    // this filter must be before OrderedHiddenHttpMethodFilter
    public static final int ORDER = FilterRegistrationBean.REQUEST_WRAPPER_FILTER_MAX_ORDER - 20000;

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // gets file size from request if present and sets it to MultipartConfigurationContext
        MultipartConfigurationContext.setMaxFileSize(150_000);

        filterChain.doFilter(request, response);

        MultipartConfigurationContext.clear();
    }
}

@Configuration
@EnableConfigurationProperties(MultipartProperties.class)
public class MultipartConfiguration {

    private final MultipartProperties multipartProperties;

    public MultipartConfiguration(MultipartProperties multipartProperties) {
        this.multipartProperties = multipartProperties;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigElement multipartConfigElement = multipartProperties.createMultipartConfig();
        return new UpdatableMultipartConfigElement(multipartConfigElement.getLocation(), multipartConfigElement.getMaxFileSize(),
                multipartConfigElement.getMaxRequestSize(), multipartConfigElement.getFileSizeThreshold());
    }

    @Bean
    public UpdateMultipartConfigurationFilter updateMultipartConfigurationFilter() {
        return new UpdateMultipartConfigurationFilter();
    }
}