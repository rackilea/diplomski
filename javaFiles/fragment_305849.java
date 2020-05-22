import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<Integer, String> someMap = new HashMap<Integer, String>();

        someMap.put(0, "nothing");
        someMap.put(7, "nothing");
        someMap.put(3, "nothing");
        someMap.put(4, "nothing");
        someMap.put(10, "nothing");
        someMap.put(11, "nothing");
        someMap.put(2, "nothing");
        someMap.put(10004, "nothing");
        someMap.put(1, "nothing");
        someMap.put(5, "nothing");

        for (Integer someInt : someMap.keySet()) {
            System.out.println(someInt);
        }
    }
}