import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<?,?> rootAsMap = mapper.readValue(
                "{\"query\":{\"latitude\":39.9889,\"longitude\":-82.8118},\"timestamp\":1310252291.861,\"address\":{\"geometry\":{\"coordinates\":[-82.81168367358264,39.9887910986731],\"type\":\"Point\"},\"properties\":{\"address\":\"284 Macdougal Ln\",\"distance\":\"0.02\",\"postcode\":\"43004\",\"city\":\"Columbus\",\"county\":\"Franklin\",\"province\":\"OH\",\"country\":\"US\"},\"type\":\"Feature\"}}".getBytes(),
                Map.class);
        System.out.println(rootAsMap);
        Map query = (Map) rootAsMap.get("query");
        Map address = (Map) rootAsMap.get("address");
        Map addressProperties = (Map) address.get("properties");
        String county = (String) addressProperties.get("county");
        System.out.println("County is " + county);
    }

}