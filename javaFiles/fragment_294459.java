String UrlLinkHref = link.attr("href");
if (UrlLinkHref.indexOf("http://") == 0) {
    setUrlBase.add(UrlLinkHref);
    for (String strUrlHash : setUrlBase) {
        writeToBase(BaseUrlTxtT, strUrlHash + "\n");
    }
}