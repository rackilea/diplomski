import org.json.JSONArray;

public class Testing {
    private JSONArray array;

    public void initObjects() {
        this.array = new JSONArray();
    }

    public JSONArray getArray() {
     return this.array;
    }

    public static void main(String args[]) {
        Testing test = new Testing();
        System.out.println(test.getArray().toString());
    }
}