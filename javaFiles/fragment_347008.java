import java.net.*;
import java.util.*;
import java.util.function.*;
import javax.ws.rs.core.UriBuilder; // using Jersey 1.18

public class StackOverflow22203111 {

    private URI withResolveURI(URI base, String targetQuery) {
        URI reference = queryOnlyURI(targetQuery);
        return base.resolve(reference);
    }

    private URI withUriBuilderReplaceQuery(URI base, String targetQuery) {
        UriBuilder builder = UriBuilder.fromUri(base);
        return builder.replaceQuery(targetQuery).build();
    }

    private URI withUriBuilderMergeURI(URI base, String targetQuery) {
        URI reference = queryOnlyURI(targetQuery);
        UriBuilder builder = UriBuilder.fromUri(base);
        return builder.uri(reference).build();
    }

    public static void main(String... args) throws Exception {

        final URI base = new URI("http://example.com/something/more/long");
        final String queryString = "query=http://local:282/rand&action=aaaa";
        final String expected =
            "http://example.com/something/more/long?query=http://local:282/rand&action=aaaa";

        StackOverflow22203111 test = new StackOverflow22203111();
        Map<String, BiFunction<URI, String, URI>> strategies = new LinkedHashMap<>();
        strategies.put("URI.resolve(URI)", test::withResolveURI);
        strategies.put("UriBuilder.replaceQuery(String)", test::withUriBuilderReplaceQuery);
        strategies.put("UriBuilder.uri(URI)", test::withUriBuilderMergeURI);

        strategies.forEach((name, method) -> {
            System.out.println(name);
            URI result = method.apply(base, queryString);
            if (expected.equals(result.toString())) {
                System.out.println("   MATCHES: " + result);
            }
            else {
                System.out.println("  EXPECTED: " + expected);
                System.out.println("   but WAS: " + result);
            }
        });
    }

    private URI queryOnlyURI(String queryString)
    {
        try {
            String scheme = null;
            String authority = null;
            String path = null;
            String fragment = null;
            return new URI(scheme, authority, path, queryString, fragment);
        }
        catch (URISyntaxException syntaxError) {
            throw new IllegalStateException("unexpected", syntaxError);
        }
    }
}