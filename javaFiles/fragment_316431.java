import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

   private static List<String> inputWords = new ArrayList<String>();
   private static Map<String, List<String>> result = new HashMap<String, List<String>>();

    public static void main(String[] args) {

        collectInput();
        process();
        generateOutput();
    }

     /*
     * Modify this method to collect the input
     * however you require it
     */
    private static void collectInput(){
        // test code
        inputWords.add("abc");
        inputWords.add("def");
        inputWords.add("abc");
        inputWords.add("ghi");
        inputWords.add("abc");
        inputWords.add("def");
        inputWords.add("abc");
    }

    private static void process(){

        // Iterate through every word in our input list
        for(int i = 0; i < inputWords.size() - 1; i++){

            // Create references to this word and next word:
            String thisWord = inputWords.get(i);
            String nextWord = inputWords.get(i+1);

            // If this word is not in the result Map yet,
            // then add it and create a new empy list for it.
            if(!result.containsKey(thisWord)){
                result.put(thisWord, new ArrayList<String>());
            }

            // Add nextWord to the list of adjacent words to thisWord:
            result.get(thisWord).add(nextWord);
        }
   }

     /*
     * Rework this method to output results as you need them:
     */
    private static void generateOutput(){
        for(Entry e : result.entrySet()){
            System.out.println("Symbol: " + e.getKey());

            // Count the number of unique instances in the list:
            Map<String, Integer>count = new HashMap<String, Integer>();
            List<String>words = (List)e.getValue();
            for(String s : words){
                if(!count.containsKey(s)){
                    count.put(s, 1);
                }
                else{
                    count.put(s, count.get(s) + 1);
                }
            }

            // Print the occurances of following symbols:
            for(Entry f : count.entrySet()){
                System.out.println("\t following symbol: " + f.getKey() + " : " + f.getValue());
            }
        }
        System.out.println();
    }
}