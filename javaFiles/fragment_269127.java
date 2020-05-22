import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.apache.commons.collections4.trie.UnmodifiableTrie;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;

public class TrieDict {

    public static void main(String[] args) {
        Trie<String, String> trie = new UnmodifiableTrie<>(new PatriciaTrie<>(fillMap()));
        String pwd = "hellothere";
        System.out.println(extractDictMatches(trie, pwd));
    }

    // Provides a dictionary
    private static Map<String, String> fillMap() {
        return ImmutableMap.<String, String>builder().
                put("there", "there").
                put("is", "is").
                put("word", "word").
                put("here", "here").
                put("hell", "hell").
                build();
    }

    private static ArrayList<String> extractDictMatches(Trie<String, String> trie, String pwd) {
        return IntStream.range(0, pwd.length()).collect(ArrayList::new, (objects, i) -> {
            String suffix = pwd.substring(i);
            IntStream.rangeClosed(0, suffix.length()).forEach(j -> {
                String suffixCut = suffix.substring(0, j);
                if (suffixCut.length() > 2) {
                    if (trie.containsKey(suffixCut)) {
                        objects.add(suffixCut);
                    }
                }
            });
        }, (objects, i) -> {
        });
    }
}