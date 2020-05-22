import java.util.Map;

public class Response {

    private int id;
    private Map<String, Map<String, Integer>> result;
    private String error;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Map<String, Integer>> getResult() {
        return result;
    }

    public void setResult(Map<String, Map<String, Integer>> result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}