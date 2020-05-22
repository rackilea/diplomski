import java.io.IOException;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Map;
 import java.util.Optional;
 import java.util.function.Function;
 import java.util.stream.Collectors;
 import java.util.stream.Stream;

 public class TestURLs implements Function<String, Optional<TestURLs.Tuple>> {

public static final int TIMEOUT = 3000;

public class Tuple {
    final String url;
    final String error;

    public Tuple(String url, String error) {
        this.url = url;
        this.error = error;
    }
}

public static enum HostNamePortExtractor implements Function<String, String>{

    INSTANCE;

    @Override
    public String apply(String url) {
        try {
            URL u = new URL(url);
            return u.getHost() + u.getPort();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

@Override
public Optional<Tuple> apply(String url) {
    HttpURLConnection connection;
    try {
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.setReadTimeout(TIMEOUT);
        connection.setConnectTimeout(TIMEOUT);
        connection.connect();
        int responseCode = connection.getResponseCode();
        // are you sure? I think you would have liked to write here "and" not or
        //if (responseCode != 200 || responseCode != 302) {
        if (responseCode != 200 && responseCode != 302) {
            return Optional.of(new Tuple(url, Integer.toString(responseCode)));
        }
    } catch (IOException e) {
        return Optional.of(new Tuple(url, e.getMessage()));
    }
    return Optional.empty();
}

public Map<String, String> process() {
        List<String> URLs = new ArrayList<>(); // add urls here
        // group by hostname+port
        Map<String, List<String>> groupedUrls = URLs.stream().collect(Collectors.groupingBy(HostNamePortExtractor.INSTANCE));
        Stream<Tuple> errors = groupedUrls.keySet().parallelStream()
                // I am not fully sure, but hoping that the stream() will go to the same thread
                .flatMap(host -> groupedUrls.get(host).stream())
                // go to the server
                .map(this::apply)
                // if there was no error, filter out the optional.empties
                .filter(o -> o.isPresent())
                // get the Tuple with url and the error
                .map(o -> o.get()); 
                // make a map
        return errors.collect(Collectors.toMap(t -> t.url, t -> t.error));
    }

public static void main(String[] args) {
    TestURLs testUrls = new TestURLs();
    testUrls.process().entrySet().forEach(e -> {
        System.out.println(e.getKey() + " error: " + e.getValue());
    });
}