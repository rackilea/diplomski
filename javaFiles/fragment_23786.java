@Override
public boolean onBeforeResourceLoad(CefBrowser cefBrowser, CefFrame cefFrame, CefRequest cefRequest) {
    if (cefRequest.getResourceType().equals(CefRequest.ResourceType.RT_IMAGE)) {
         cefRequest.setURL("https://yghjbnbk.com");
         System.out.println("LOL!");
    }
    return false;
}