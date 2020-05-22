public static void main(String[] args) throws Exception {
    // turn off htmlunit warnings
    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

    WebClient webClient = new WebClient();
    HtmlPage page = webClient.getPage("http://stackoverflow.com");
    System.out.println(page.getTitleText());
}