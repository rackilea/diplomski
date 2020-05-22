import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

/**
 * http://stackoverflow.com/q/30288878/3080094
 * Using jackson-databind-2.5.3 which uses
 * jackson-annotations-2.5.0 and
 * jackson-core-2.5.3
 * @author vanOekel
 */
public class JsonTest {

    public static void main(String[] args) {

        try {
            new JsonTest().getNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ObjectMapper jsonMapper = new ObjectMapper();
    JsonFactory jsonFactory = new JsonFactory();

    void getNames() throws Exception {

        final String resourceName = "some.json";
        JsonNode jn;
        try (InputStream in = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)
                ) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + resourceName);
            }
            jn = jsonMapper.readTree(in);
        } 
        findByPath(jn);

        try (InputStream in = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)
                ) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + resourceName);
            }
            JsonParser jsonParser = jsonFactory.createParser(in);
            findInStream(jsonParser);
        } 
    }

    final String[] path = new String[] {"myReport", "docReports", "part1/.", "myAnalysis", "matches", "name"};

    void findByPath(JsonNode jn) {

        JsonNode matchesNamesNode = jn;
        for (int i = 0; i < path.length - 1; i++) {
            matchesNamesNode = matchesNamesNode.path(path[i]);
        }
        if (matchesNamesNode.isMissingNode()) {
            throw new RuntimeException("No node with names found.");
        }
        System.out.println("Tree names: " + matchesNamesNode.findValuesAsText(path[path.length - 1]));
    }

    void findInStream(JsonParser jp) throws Exception {

        int pathIndex = 0;
        List<String> names = new ArrayList<String>();
        boolean breakOnClose = false;

        while (jp.nextToken() != null) {
            final String fieldName = jp.getCurrentName();
            if (fieldName == null) {
                continue;
            }
            if (breakOnClose && fieldName.equals(path[path.length - 2])) {
                System.out.println("Stopping search at end of node " + fieldName);
                break;
            }
            if (jp.getCurrentToken() != JsonToken.FIELD_NAME) {
                continue;
            }
            // System.out.println("Field " + fieldName);
            if (pathIndex >= path.length - 1) {
                if (fieldName.equals(path[path.length - 1])) {
                    // move from field name to field value.
                    jp.nextToken(); 
                    String name = jp.getValueAsString();
                    if (name == null) {
                        throw new RuntimeException("No value exists for field " + fieldName);
                    }
                    names.add(name);
                    System.out.println("Found " + fieldName + " value: " + name);
                }
            } else if (fieldName.equals(path[pathIndex])) {
                System.out.println("Found node " + path[pathIndex]);
                pathIndex++;
                if (pathIndex >= path.length - 1) {
                    System.out.println("Looking for names ...");
                    breakOnClose = true;
                    // prevent breaking on "matches" value json-token.
                    jp.nextFieldName(); 
                }
            }
        }
        System.out.println("Streaming names: " + names);
    }

}