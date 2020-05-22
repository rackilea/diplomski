import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        List<Integer> hookSizesList = new ArrayList<Integer>();
        hookSizesList.add(1);
        hookSizesList.add(4);
        hookSizesList.add(5);

        for (Integer hook: hookSizesList) {
             System.out.print(hook + " ");
        }
    }
}