public NutchDocument filter(NutchDocument doc, String url, WebPage page)
    throws IndexingException {
    String input_url = url;
    try {
        url = urlNormalizers.normalize(url, URLNormalizers.SCOPE_DEFAULT);
        url = urlFilters.filter(url); // filter the url
    } catch (Exception e) {
        LOG.warn("Skipping " + input_url + ":" + e);
        return null;
    }  
    if (url == null) {
        LOG.info("Skipping (filter): " + input_url);
        return null;
    }  
    return doc;
}

public void setConf(Configuration conf) {
    this.conf = conf;
    this.urlFilters = new URLFilters(conf);
    urlNormalizers = new URLNormalizers(conf, URLNormalizers.SCOPE_INJECT);
}