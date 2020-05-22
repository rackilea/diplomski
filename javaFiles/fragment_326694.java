import java.util.*;
import java.io.*;

public class Project6 {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) die("Must give name of two input files on cmd line.");

        BufferedReader dFile = new BufferedReader(new FileReader(args[0]));
        BufferedReader jFile = new BufferedReader(new FileReader(args[1]));

        HashMap<String, List<String>> dWordMap = new HashMap<String, List<String>>();

        long startTime = System.currentTimeMillis();

        while (dFile.ready()) {
            String word = dFile.readLine();
            if (word == null) break;

            addWord(word, dWordMap);
        }
        dFile.close();

        while (jFile.ready()) {
            String jWord = jFile.readLine();
            if (jWord == null) break;

            List<String> dWords = dWordMap.get(createKey(jWord));

            if (dWords != null) {
                System.out.println(jWord + " " + dWords);
            }
        }
        jFile.close();

        long endTime = System.currentTimeMillis();
        long ms = endTime - startTime;
        System.out.println("Elapsed time in seconds: " + ms / 1000.0 + "\n");
    }

    private static void die(String errmsg) {
        System.out.println("\nFATAL ERROR: " + errmsg + "\n");
        System.exit(0);
    }

    private static String createKey(String word) {
        char[] chword = word.toLowerCase().toCharArray();
        Arrays.sort(chword);

        return new String(chword);
    }

    private static void addWord(String word, Map<String, List<String>> map) {
        String key = createKey(word);

        List<String> list = map.get(key);
        if(list==null) {
            list = new ArrayList<String>();
            map.put(key, list);
        }

        list.add(word);
    }
}