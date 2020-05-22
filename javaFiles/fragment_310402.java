import java.util.*;
public class Shift {

    public static void main(String args[]) {

        String speech = "Sentence:NounPhrase VerbPhrase:NounPhrase :Art " +
                        "Noun:VerbPhrase : Verb | Adverb Verb: Art : the | " +
                        "a : Verb :jumps | sings |: Noun:dog | cat | ";

        Map<String, Set<String>> hashmap = new HashMap<String, Set<String>>();

        StringTokenizer st = new StringTokenizer(speech, ":");

        while (st.hasMoreTokens()) {
            String key = st.nextToken().trim();
            String value = st.nextToken().trim();

            StringTokenizer st1 = new StringTokenizer(value, "|");

            while (st1.hasMoreTokens()) {
                String a = st1.nextToken().trim();

                if (!hashmap.containsKey(key))
                    hashmap.put(key, new HashSet<String>());

                hashmap.get(key).add(a);
            }
        }

        for (String key : hashmap.keySet())
            System.out.printf("%s -> %s%n", key, hashmap.get(key));
    }
}