import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.googleapis.GoogleTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonHttpContent;
import com.google.api.client.json.JsonHttpParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;


public class Shortener {

    public static final String GOOGL_URL = "https://www.googleapis.com/urlshortener/v1/url";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // setup up the HTTP transport
        HttpTransport transport = GoogleTransport.create();
        // add default headers
        GoogleHeaders defaultHeaders = new GoogleHeaders();
        transport.defaultHeaders = defaultHeaders;
        transport.defaultHeaders.put("Content-Type", "application/json");
        transport.addParser(new JsonHttpParser());

        // build the HTTP GET request and URL
        HttpRequest request = transport.buildPostRequest();
        request.setUrl(GOOGL_URL);
        GenericData data = new GenericData();
        data.put("longUrl", "http://www.google.com/");
        JsonHttpContent content = new JsonHttpContent();
        content.data = data;
        request.content = content;

        HttpResponse response = request.execute();
        Result result = response.parseAs(Result.class);

        System.out.println(result.shortUrl);
    }

    public static class Result extends GenericJson {        
        @Key("id")
        public String shortUrl;
    }
}