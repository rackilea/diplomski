import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        List<List<Integer>> listOfListOfInt = new ArrayList<>();
        listOfListOfInt.add(intList);
        method1(listOfListOfInt);
        System.out.println(listOfListOfInt);
    }
    private static void method1(List<? extends List> cont) { // [1]
        List<? super Date> data = cont.get(0);  // [2]
        data.add(new Date());
    }
}