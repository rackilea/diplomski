import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        // workaround for SSL not related with a question
        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();

        String url = "https://www.api-football.com/demo/api/v2/leagues";

        ObjectMapper mapper = new ObjectMapper()
                // ignore JSON properties which are not mapped to POJO
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // we do not want to build model for whole JSON payload
        JsonNode node = mapper.readTree(new URL(url));

        // go to leagues JSON Array
        JsonNode leaguesNode = node.at(JsonPointer.compile("/api/leagues"));

        // deserialise "leagues" JSON Array to List of POJO
        List<League> leagues = mapper.convertValue(leaguesNode, new TypeReference<List<League>>(){});
        leagues.forEach(System.out::println);
    }
}

class League {
    @JsonProperty("league_id")
    private int id;
    private String name;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}