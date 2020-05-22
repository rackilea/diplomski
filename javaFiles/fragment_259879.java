public abstract class QueryMatch {

    private String key;

    public QueryMatch(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public abstract void addMatch(String match);
}


public class QueryMatchOr extends QueryMatch {

    private ArrayList<String> input;

    public QueryMatchOr() {
        super("title");
        input = new ArrayList<String>();
    }

    public void addMatch(String match) {
        input.add(match);
    }
}