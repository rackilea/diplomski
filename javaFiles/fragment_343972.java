public void testHomePage() throws Exception { 
    final WebClient webClient = new WebClient(); 
    final URL url = new URL("http://htmlunit.sourceforge.net"); 

    final HtmlPage page = (HtmlPage)webClient.getPage(url); 

    HtmlAnchor anchor = page.getAnchorByName("Home"); 
    anchor.click();
}