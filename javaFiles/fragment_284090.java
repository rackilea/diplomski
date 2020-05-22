import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> test = new LinkedList<String>();
        test.add("Ali Baba");
        test.add("Papa Bill");
        test.add("Marcus");
        test.add("Ali Baba");
        test.add("Marcus");
        test.add("Ali Baba");
        LinkedList<Pair<String, Integer>> result = convert(test);
        for(Pair<String, Integer> res : result) {
            System.out.println(res.getFirst() + " :" + res.getSecond());
        }
    }

    public static <T> LinkedList<Pair<T, Integer>> convert(LinkedList<T> in) {
        LinkedList<Pair<T, Integer>> returnList = new LinkedList<>();
        LinkedList<T> tmp = new LinkedList<T>();
        // iterate over your list to count the items
        for(T item : in) {
            // if you already counted the current item, skip it
            if(tmp.contains(item)) {
                continue;
            }
            // counter for the current item
            int counter = 0;

            //iterate again over your list to actually count the item
            for(T item2 : in) {
                if(item.equals(item2)) {
                    counter ++;
                }
            }
            // create your pair for your result list and add it
            returnList.add(new Pair<T, Integer>(item, counter));

            // mark your item as already counted
            tmp.add(item);
        }
        return returnList;
    }
}