import java.util.Arrays;
import java.util.LinkedList;

public class Index {

    public static void main(String[] args) {

        // LinkedList

        LinkedList<Integer> k = new LinkedList<Integer>() {
            {
                addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
            }
        };


        System.out.println("Initial List:           " + k);
        k.remove(); //Retrieves and removes the head (first element) of this list.
        System.out.println("List after k.remove():  " + k);
        k.remove(2); //Removes the element at the specified position in this list.
        System.out.println("List after k.remove(2): " + k);
        k.removeFirst();//Removes and returns the first element from this list.
        System.out.println("List after k.removeFirst():" + k);
        k.removeLast();//Removes and returns the last element from this list.
        System.out.println("List after k.removeLast(): " + k);
    }
}