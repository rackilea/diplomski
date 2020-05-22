import java.util.ArrayList;
import java.util.List;

public class Pascal {
    static List<List<Integer>> l = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int noOfRows = 5;
        int counter = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        generate(list, counter, noOfRows);
        System.out.println(l);
    }

    public static List<Integer> generate(List<Integer> list, int counter, int noOfRows) {
        l.add(list);
        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(1);
        for (int i = 1; i < list.size(); i++) {
            tempList.add(list.get(i) + list.get(i - 1));
        }
        tempList.add(1);
        if (counter != noOfRows)
            generate(tempList, ++counter, noOfRows);
        return tempList;
    }
}