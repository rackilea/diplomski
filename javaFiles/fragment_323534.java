import org.json.JSONArray;

public class Test {
    public static void main(String[] args) {
        String val = "[\"One\", \"Two\"]";

        JSONArray jsonArr = new JSONArray(val);  
        for (int i = 0; i < jsonArr.length(); i++) {
            System.out.println( jsonArr.getString( i ) );
        }
    }
}