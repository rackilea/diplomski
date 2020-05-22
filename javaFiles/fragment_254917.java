@Component(immediate = true)
@Service
@Properties({
    @Property(name = ServletResolverConstants.SLING_SERVLET_PATHS, value = "/my/servlet/path"),
    @Property(name = ServletResolverConstants.SLING_SERVLET_METHODS, value = { HttpConstants.METHOD_GET })
})

public class MyServlet extends SlingSafeMethodsServlet {
    @Reference
    LoginServiceClient loginServiceClient;
...
}