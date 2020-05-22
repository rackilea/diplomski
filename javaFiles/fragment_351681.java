import java.util.HashMap;

public class MapPutExample {

    public final static void main(String[] args) throws Exception {
        HashMap<String, char[]> map = new HashMap<>();

        char[] buffer = new char[10];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (char) ('a' + i);
        }
        map.put("String1", buffer);
        buffer = new char[10];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (char) ('k' + i);
        }
        map.put("String2", buffer);
        System.out.println(map.get("String1")); //would print klmnopqrst
    }
}