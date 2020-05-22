import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SimpleInvertedIndex {

    public static void main(String[] args) {

        //inverted index
        Map<String, LinkedList<String>> index = new TreeMap<>();

        //tweets data
        Map<String, String> tweets = new HashMap<>();

        //Sample tweets
        tweets.put("Tweet1", " I am A");
        tweets.put("Tweet2", "I am B");

        //build the inverted index
        for (Map.Entry<String, String> entry : tweets.entrySet()) {
            String tweetId = entry.getKey();
            String[] values = entry.getValue().trim().split(" ");

            for (int i = 0; i < values.length; i++) {
                index.putIfAbsent(values[i], new LinkedList<>());
                LinkedList<String> updatedList = index.get(values[i]);
                updatedList.add(tweetId);
                index.put(values[i], updatedList);
            }
        }

        //verify by printing out
        for (Map.Entry<String, LinkedList<String>> entry : index.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }
}