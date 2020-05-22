import java.net.URLEncoder;

public class QueryString {

    private String query = "";

    public QueryString(HashMap<String, String> map) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            query += URLEncoder.encode(pairs.getKey(), "utf-8") + "=" +
            URLEncoder.encode(pairs.getValue(), "utf-8");
            if (it.hasNext()) { query += "&"; }
        }
    }

    public QueryString(Object name, Object value) {
        query = URLEncoder.encode(name.toString(), "utf-8") + "=" +
            URLEncoder.encode(value.toString(), "utf-8");
    }

    public QueryString() { query = ""; }

    public synchronized void add(Object name, Object value) {
        if (!query.trim().equals("")) query += "&";
        query += URLEncoder.encode(name.toString(), "utf-8") + "=" +
            URLEncoder.encode(value.toString(), "utf-8");
    }

    public String toString() { return query; }
}