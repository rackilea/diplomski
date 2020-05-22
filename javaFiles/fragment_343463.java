import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Hola");
        arrayList.add("Hallo");

        boolean contains = arrayList.contains("Hello");

        System.out.println(contains);
    }
}