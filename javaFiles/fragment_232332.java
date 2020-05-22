import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

...

public void postMethod(HashMap<String,Object> input) {
    ObjectNode jsonBody = JsonNodeFactory.instance.objectNode();
    for (Map.Entry<String, Object> entry : input.entrySet())
    {
        String key = entry.getKey();
        Object value = entry.getValue();

        if (value instanceof Double)
            jsonBody.put(key, (Double)value);
        else if (value instanceof Boolean)
            jsonBody.put(key, (Boolean)value);
        else
            jsonBody.put(key, value);
    }

    // ... make headers ...

    HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody.toString(), headers);

    // ... make the post request ...
}