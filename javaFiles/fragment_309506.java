import java.util.Collections;
import java.util.LinkedList;

public class Test{

    @SafeVarargs
    public static LinkedList<Object> combineAndShuffle(LinkedList<?>... l){
        //must be <Object> because it needs to hold multiple types of objects
        LinkedList<Object> finalList = new LinkedList<>();

        //use <?> wildcard because we are unsure what value we will hit
        for(LinkedList<?> list: l) {
            finalList.addAll(list);
        }
        //shuffle the list
        Collections.shuffle(finalList);

        return finalList;
    }

    public static void main(String [] args){
        //list of strings
        LinkedList<String> listA = new LinkedList<>();
        listA.add("One");
        listA.add("Two");

        //list of integers, so a different class type
        LinkedList<Integer> listB = new LinkedList<>();
        listB.add(3);
        listB.add(4);

        LinkedList<Object> combinedList = combineAndShuffle(listA, listB);
        for(Object item: combinedList)
            System.out.println(item);   
    }
}