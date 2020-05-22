package helpers;

import play.mvc.Http.Response;

public class CookieLessResponseWrapper extends Response {
    private Response wrappedResponse;

    public CookieLessResponseWrapper(Response response) {
        this.wrappedResponse = response;
    }

    @Override
    public void accessControl(String allowOrigin, boolean allowCredentials) {
        wrappedResponse.accessControl(allowOrigin, allowCredentials);
    }

    @Override
    public void accessControl(String allowOrigin, String allowMethods,
            boolean allowCredentials) {
        wrappedResponse.accessControl(allowOrigin, allowMethods, allowCredentials);
    }

    @Override
    public void accessControl(String allowOrigin) {
        wrappedResponse.accessControl(allowOrigin);
    }

    @Override
    public void cacheFor(String etag, String duration, long lastModified) {
        wrappedResponse.cacheFor(etag, duration, lastModified);
    }

    @Override
    public void cacheFor(String duration) {
        wrappedResponse.cacheFor(duration);
    }

    @Override
    public String getHeader(String name) {
        return wrappedResponse.getHeader(name);
    }

    @Override
    public void print(Object o) {
        wrappedResponse.print(o);
    }

    @Override
    public void removeCookie(String name) {
        wrappedResponse.removeCookie(name);
    }

    @Override
    public void reset() {
        wrappedResponse.reset();
    }

    @Override
    public void setContentTypeIfNotSet(String contentType) {
        wrappedResponse.setContentTypeIfNotSet(contentType);
    }

    @Override
    public void setCookie(String name, String value, String domain,
            String path, Integer maxAge, boolean secure, boolean httpOnly) {
    }

    @Override
    public void setCookie(String name, String value, String domain,
            String path, Integer maxAge, boolean secure) {
    }

    @Override
    public void setCookie(String name, String value, String duration) {
    }

    @Override
    public void setCookie(String name, String value) {
    }

    @Override
    public void setHeader(String name, String value) {
        wrappedResponse.setHeader(name, value);
    }

}