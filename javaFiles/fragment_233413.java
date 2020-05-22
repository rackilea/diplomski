public static void test8() throws URISyntaxException {
    String urlString = "mailto:mduerst@ifi.unizh.ch";
    URI uri = new URI(urlString);
    printUri(uri); 
    // Output:
    //  toString() --> mailto:mduerst@ifi.unizh.ch
    //  getPath --> null
    //  getPath null? true          
}