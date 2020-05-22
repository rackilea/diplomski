import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class MyClass {
    public static void main(String args[]) {
        Map<String, Integer> wordList = new HashMap<>();
        wordList.put("alabanza", 3);
        wordList.put("esperanza", 4);
        wordList.put("comunal", 3);
        wordList.put("aprender", 1);

        Map<String, Integer> results = new HashMap<>(4);
        for (int i = 0; i < 100; i++) {
            String name = randomize(wordList);
            Integer old = results.getOrDefault(name, 0);
            results.put(name, old + 1);
        }

        for (Map.Entry<String, Integer> e : results.entrySet()) {
            System.out.println(e.getKey() + "\t" + e.getValue());
        }
    }

    private static String randomize(Map<String, Integer> wordList) {
        final Integer sum = wordList.values().stream().reduce(Integer::sum).orElse(0);
        final int grandSum = (wordList.size() - 1) * sum;
        final int random = new Random().nextInt(grandSum + 1);

        int index = 0;
        for (Map.Entry<String, Integer> e: wordList.entrySet()) {
            index += (sum - e.getValue());
            if (index >= random) {
                return e.getKey();
            }
        }
        return null;
    }
}