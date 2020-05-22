import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomList {

private static List<String> getSubList(List<String> list, int percentage) {
    return list.subList(0, (percentage / 10));
}

public static void main(String[] args) {

    String[] array1 = { "dog", "cat", "rabbit", "bat", "zebra", "bear",
            "turtle", "mouse", "fly", "bird" };

    List<String> list1 = new ArrayList<String>();
    list1.addAll(Arrays.asList(array1));

    String[] array2 = { "bee", "horse", "mule", "cow", "fish", "shark",
            "lion", "tiger", "elephant", "panther" };

    List<String> list2 = new ArrayList<String>();
    list2.addAll(Arrays.asList(array2));

    List<String> list_mix = new ArrayList<String>();
    list_mix.addAll(getSubList(list1, 60));
    list_mix.addAll(getSubList(list2, 40));

    Collections.shuffle(list_mix);

    System.out.println("list1 : " + list1);


    System.out.println("list2 : " + list2);
        System.out.println("list_mix : " + list_mix);

    }
}