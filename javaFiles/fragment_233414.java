public static void test9() throws URISyntaxException {
    String urlString = "news:comp.infosystems.www.servers.unix";
    URI uri = new URI(urlString);
    printUri(uri); 
    // Output:
    //  toString() --> news:comp.infosystems.www.servers.unix
    //  getPath --> null
    //  getPath null? true          
}