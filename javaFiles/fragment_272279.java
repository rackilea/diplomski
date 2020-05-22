import java.util.HashMap;

public class StackOverflow {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("hello", "hello world");
        System.out.println(map.get("hello"));
    }
}