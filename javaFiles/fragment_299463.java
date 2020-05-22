public class CookieAddedWebTarget implements WebTarget {

    private WebTarget base;

    private Cookie cookie;

    public CookieAddedWebTarget(WebTarget base, Cookie cookie) {
        this.base = base;
        this.cookie = cookie;
    }

    // Inject that cookie whenever someone requests a Builder (like EventSource does):
    public Builder request() {
        return base.request().cookie(cookie);
    }

    public Builder request(String... paramArrayOfString) {
        return base.request(paramArrayOfString).cookie(cookie);
    }

    public Builder request(MediaType... paramArrayOfMediaType) {
        return base.request(paramArrayOfMediaType).cookie(cookie);
    }

    public Configuration getConfiguration() {
        return base.getConfiguration();
    }

    //All other methods from WebTarget are delegated as-is:

    public URI getUri() {
        return base.getUri();
    }

    public UriBuilder getUriBuilder() {
        return base.getUriBuilder();
    }

    public WebTarget path(String paramString) {
        return base.path(paramString);
    }

    public WebTarget matrixParam(String paramString, Object... paramArrayOfObject) {
        return base.matrixParam(paramString, paramArrayOfObject);
    }

    public WebTarget property(String paramString, Object paramObject) {
        return base.property(paramString, paramObject);
    }

    public WebTarget queryParam(String paramString, Object... paramArrayOfObject) {
        return base.queryParam(paramString, paramArrayOfObject);
    }

    public WebTarget register(Class<?> paramClass, Class<?>... paramArrayOfClass) {
        return base.register(paramClass, paramArrayOfClass);
    }

    public WebTarget register(Class<?> paramClass, int paramInt) {
        return base.register(paramClass, paramInt);
    }

    public WebTarget register(Class<?> paramClass, Map<Class<?>, Integer> paramMap) {
        return base.register(paramClass, paramMap);
    }

    public WebTarget register(Class<?> paramClass) {
        return base.register(paramClass);
    }

    public WebTarget register(Object paramObject, Class<?>... paramArrayOfClass) {
        return base.register(paramObject, paramArrayOfClass);
    }

    public WebTarget register(Object paramObject, int paramInt) {
        return base.register(paramObject, paramInt);
    }

    public WebTarget register(Object paramObject, Map<Class<?>, Integer> paramMap) {
        return base.register(paramObject, paramMap);
    }

    public WebTarget register(Object paramObject) {
        return base.register(paramObject);
    }

    public WebTarget resolveTemplate(String paramString, Object paramObject) {
        return base.resolveTemplate(paramString, paramObject);
    }

    public WebTarget resolveTemplate(String paramString, Object paramObject, boolean paramBoolean) {
        return base.resolveTemplate(paramString, paramObject, paramBoolean);
    }

    public WebTarget resolveTemplateFromEncoded(String paramString, Object paramObject) {
        return base.resolveTemplateFromEncoded(paramString, paramObject);
    }

    public WebTarget resolveTemplates(Map<String, Object> paramMap) {
        return base.resolveTemplates(paramMap);
    }

    public WebTarget resolveTemplates(Map<String, Object> paramMap, boolean paramBoolean) {
        return base.resolveTemplates(paramMap, paramBoolean);
    }

    public WebTarget resolveTemplatesFromEncoded(Map<String, Object> paramMap) {
        return base.resolveTemplatesFromEncoded(paramMap);
    }

}