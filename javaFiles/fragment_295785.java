public static void main(String[] args) throws Exception {
    String base = "http://abc.com.br/index.php?hello=world";
    String relative = "?test=xyz";

    System.out.println(new URL(new URL(base), relative).toExternalForm());
    // http://abc.com.br/?test=xyz

    System.out.println((new URI(base)).resolve(relative).toString());
    // http://abc.com.br/?test=xyz

    System.out.println(org.apache.http.client.utils.URIUtils.resolve(new URI(base), relative).toString());
    // http://abc.com.br/index.php?test=xyz
}