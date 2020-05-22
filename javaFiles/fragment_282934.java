private static String chatOverlay(Page checkPage, String url) {
    //changed the name of the local variable
    Page checkedPage = resource.resourceResolver.getResource(url).adaptTo(Page);
    url = (checkedPage) ? ".html" : "";
    return url;
}