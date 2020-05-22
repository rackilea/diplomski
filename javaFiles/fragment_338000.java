import java.util.*;

class CustomComparator implements Comparator<String> {
    final String ORDER= "23456789TJQKA";
    public int compare(String a, String b) {
        return ORDER.indexOf(a) -  ORDER.indexOf(b) ;
    }
}

public class SortIt {

    public static void main(String[] args) {
        List cards = new ArrayList<>(Arrays.asList("K", "A", "7", "Q", "6", "J", "T"));
        Collections.sort(cards, new CustomComparator());
        System.out.println(cards);

    }
}