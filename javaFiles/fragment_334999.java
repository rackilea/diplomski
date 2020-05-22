import java.nio.file.*;
import com.jayway.jsonpath.*;
public class JsonPathDemo
{
    public static void main(String[] args)
    {
        // query: get all json objects that have displayName and dataType properties
        String jsonPathQuery = "$..*[?(@.displayName && @.dataType)]";
        try {
            String content = new String(Files.readAllBytes(Paths.get("C://temp/xx.json")));
            Object parsedContent = Configuration.defaultConfiguration().jsonProvider().parse(content);
            Object configElements = JsonPath.read(parsedContent, jsonPathQuery);
            System.out.println(configElements.getClass());
            System.out.println(configElements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}