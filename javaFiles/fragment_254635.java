Date cachedAt = null;
String cachedContent = null;

String getCachedThing() {
    if (cachedContent != null && cachedAt != null && 
            new Date().before(cachedAt)) {
        return cachedContent;
    }
    getThing();
    return cachedContent;
}

private void getThing() {
    // get resource.
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MINUTE, 20);
    cachedAt = cal.getTime();
    cachedContent = "myWebPage";
}