public abstract class QueryMatch<T> {

    private String key;

    public QueryMatch(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public abstract void addMatch(String match);

    public abstract T getValue();
}


public class QueryMatchOr extends QueryMatch<ArrayList<String>> {

    private ArrayList<String> input;

    public QueryMatchOr() {
        super("title");
        input = new ArrayList<String>();
    }

    public void addMatch(String match) {
        input.add(match);
    }

    public ArrayList<String> getValue(String match) {
        input;
    }
}