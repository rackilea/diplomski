import java.util.List;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

@Service
public class GoogleSearchService {


    @Async
    public void searchGoogle(List<String> keywords){
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            JSONParser parser = new JSONParser();
            GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
            url.put("query", "Kolkata");
            url.put("limit", "1");
            url.put("indent", "true");
            url.put("key", "xxxxxx");
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse httpResponse = request.execute();
            String responseString = httpResponse.parseAsString();

            JsonNode node = mapper.readTree(responseString).get("itemListElement").get(0).get("result");
            System.out.println(node.get("name"));
            System.out.println(node.get("@type"));
            System.out.println(node.get("detailedDescription").get("articleBody"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}