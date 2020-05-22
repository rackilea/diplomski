boolean useWindowsAuthentication = true;
HttpUriRequest request;
CloseableHttpClient httpclient;
if (useWindowsAuthentication){
    log.info("Using Windows Authentication");
    httpclient = WinHttpClients.createDefault();    
} else {
    httpclient = HttpClients.createDefault();
}