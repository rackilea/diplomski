public class CefClientRequestHandler extends CefRequestHandlerAdapter {
    @Override
    public boolean onBeforeResourceLoad(CefBrowser cefBrowser, CefFrame cefFrame, CefRequest cefRequest) {
        if (cefRequest.getResourceType().equals(RT_IMAGE)) {
            cefRequest.setMethod("HEAD");
        }
        return false;
    }

    // other overridden methods here...
}