public void post() throws Exception
{

    URL url = new URL("YOURURL");
    WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);

    requestSettings.setAdditionalHeader("Accept", "*/*");
    requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    requestSettings.setAdditionalHeader("Referer", "REFURLHERE");
    requestSettings.setAdditionalHeader("Accept-Language", "en-US,en;q=0.8");
    requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate,sdch");
    requestSettings.setAdditionalHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
    requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
    requestSettings.setAdditionalHeader("Cache-Control", "no-cache");
    requestSettings.setAdditionalHeader("Pragma", "no-cache");
    requestSettings.setAdditionalHeader("Origin", "https://YOURHOST");

    requestSettings.setRequestBody("REQUESTBODY");

    Page redirectPage = webClient.getPage(requestSettings);
}