public class StackOverflow26177749 {

    public static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
        URI oldUri = new URI(uri);

        String newQuery = oldUri.getQuery();
        if (newQuery == null) {
            newQuery = appendQuery;
        } else {
            newQuery += "&" + appendQuery;  
        }

        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
                oldUri.getPath(), newQuery, oldUri.getFragment());

        return newUri;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(appendUri("http://example.com", "name=John"));
        System.out.println(appendUri("http://example.com#fragment", "name=John"));
        System.out.println(appendUri("http://example.com?email=john.doe@email.com", "name=John"));
        System.out.println(appendUri("http://example.com?email=john.doe@email.com#fragment", "name=John"));
    }
}