public class Test {
public static void main(String[] args) {
    JSONArray users = new JSONArray();
    users.add(new Entry("key1", "val1"));
    users.add(new Entry("key2", "val2"));        

    System.out.println(users);
}

static class Entry implements JSONAware {
    private String name;
    private String interests;

    public Entry(String name, String interests) {
        this.name = name;
        this.interests = interests;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{");

        sb.append(JSONObject.escape("name"));
        sb.append(":");
        sb.append("\"" + JSONObject.escape(name) + "\"");

        sb.append(",");

        sb.append(JSONObject.escape("interests"));
        sb.append(":");
        sb.append("\"" + JSONObject.escape(name) + "\"");

        sb.append("}");

        return sb.toString();
    }
}