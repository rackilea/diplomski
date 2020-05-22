public class MyArrayNode {

    private JSONArray array;

    public MyArrayNode(JSONArray array) {
        this.array = array;
    }

    public JSONArray getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "(", ")");
        array.forEach(a -> sj.add(a.toString()));
        return sj.toString();
    }
}