String UrlLinkHref = link.attr("href");
if (UrlLinkHref.indexOf("http://") == 0) {
    if (setUrlBase.add(UrlLinkHref)){//will return true if link wasn't in set yet
        writeToBase(BaseUrlTxtT, UrlLinkHref + "\n");// so we also want to write 
                                                     // it to file
    }
}