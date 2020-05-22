import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static <E> ArrayList<E> newArrayList(E... elements) {
        ArrayList<E> list = new ArrayList<>(elements.length);
        Collections.addAll(list, elements);
        return list;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<ArrayList<String>>> lists = newArrayList(
            newArrayList(
                newArrayList("A"),
                newArrayList("B")
            ),
            newArrayList(
                newArrayList("A", "B"),
                newArrayList("C")
            ),
            newArrayList(
                newArrayList("B", "D"),
                newArrayList("E")
            )
        );

        System.out.println(lists);
    }
}