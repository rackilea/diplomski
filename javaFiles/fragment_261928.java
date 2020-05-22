import java.util.stream.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        List < String > bla = new ArrayList();
        bla.add("one");
        bla.add("something");
        bla.add("two");

        String bla2 = bla
            .stream()
            .filter(s -> s.equals("something"))
            .findAny()
            .get();

        System.out.println(bla2);
    }
}