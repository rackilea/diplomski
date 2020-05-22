import com.zaxxer.hikari.util.FastList;

public class Main {

    public static void main(String[] args) {

        FastList<String> fastList = new FastList<>(String.class);
        fastList.add("Hello");
        System.out.println(fastList);
    }
}