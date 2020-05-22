public static void main(String[] args) {

    WebClient webClient = new WebClient(BrowserVersion.CHROME);

    XmlPage page = null;

    webClient = new WebClient(BrowserVersion.CHROME);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setActiveXNative(false);
    webClient.getOptions().setAppletEnabled(false);
    webClient.getOptions().setCssEnabled(true);
    webClient.getOptions().setPopupBlockerEnabled(true);
    webClient.getOptions().setPrintContentOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnScriptError(true);
    webClient.getOptions().setTimeout(100000);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setDoNotTrackEnabled(false);
    //webClient.getOptions().setProxyConfig(new ProxyConfig("10.0.0.1", 8080));

    try {

        //go to url
        page = webClient.getPage("http://www.w3schools.com/xml/note.xml");
        System.out.println(xpage.asXml());

        //just for test save to file to see results
        File file = new File("result.html");
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(xpage.asXml().getBytes());
        fos.close();
        //end test

    } catch (Exception e) {
        System.out.println("An error occurs when getting the page: "+e);

    }

}