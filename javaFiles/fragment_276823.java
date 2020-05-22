import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A <code>JsonObject</code> represents a JSON object, which begins and ends 
 * with curly braces '{' '}' and contains key-value pairs separated by a 
 * colon ':'.
 * <p>
 * In implementation, this is simply an extended <code>LinkedHashMap</code> to 
 * represent key-value pairs and to preserve insert order (which may be 
 * required by some JSON implementations, though is not a standard).
 * <p>
 * Additionally, calling <code>toString()</code> on the <code>JsonObject</code> 
 * will return a properly formatted <code>String</code> which can be posted as 
 * a value JSON HTTP request or response.
 * @author Andrew
 * @param <V> the value class to use. Note that all keys for a 
 *          <code>JsonObject</code> are <code>Strings</code>
 */
public class JsonObject<V> extends LinkedHashMap<String, V> {

    /**
     * Creates a new empty <code>JsonObject</code>.
     */
    public JsonObject() {

    }
    /**
     * Creates a new <code>JsonObject</code> from the given HTTP response 
     * <code>String</code>.
     * @param source HTTP response JSON object
     * @throws IllegalArgumentException if the given <code>String</code> is not 
     *          a JSON object, or if it is improperly formatted
     * @see JsonParser#getJsonObject(java.lang.String) 
     */
    public JsonObject(String source) throws IllegalArgumentException {
        this(JsonParser.getJsonObject(source));
    }
    /**
     * Creates a new <code>JsonObject</code> from the given <code>Map</code>.
     * @param map a <code>Map</code> of key-value pairs to create the 
     *          <code>JsonObject</code> from
     */
    public JsonObject(Map<? extends String, ? extends V> map) {
        putAll(map);
    }

    /**
     * Returns a JSON formatted <code>String</code> that properly represents 
     * this JSON object.
     * <p>
     * This <code>String</code> may be used in an HTTP request or response.
     * @return JSON formatted JSON object <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        Iterator<Map.Entry<String, V>> iter = entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, V> entry = iter.next();
            sb.append(JsonParser.toJson(entry.getKey()));
            sb.append(':');

            V value = entry.getValue();
            sb.append(JsonParser.toJson(value));
            if (iter.hasNext()) {
                sb.append(',');
            }

        }
        sb.append("}");        
        return sb.toString();
    }
}