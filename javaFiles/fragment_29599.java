import java.util.ArrayList;
import java.util.List;

public class CompareArrayListTest{

 public static void main(String[] args) {

    ArrayList<String> firstList = new ArrayList<String>();

    firstList.add("book1");
    firstList.add("book2");
    firstList.add("book3");
    firstList.add("book4");

    ArrayList<String> secondList = new ArrayList<String>();

    secondList.add("book1");
    secondList.add("book2");
    secondList.add("book3");

    List<Integer> comparingList = new ArrayList<Integer>();
    // adding default values as one
    for (int a = 0; a < firstList.size(); a++) {
        comparingList.add(0);

    }

    for (int counter = 0; counter < firstList.size(); counter++) {
        if (secondList.contains(firstList.get(counter))) {
            comparingList.set(counter, 1);
        }
    }

    System.out.println(comparingList);

}