public class G {
public static void main(String[] args) {
    new G().printCharacterCount("ABCABBABCAB");
    System.out.println();
    new G().printUniqueCharacters("Hello", "world");
}

void printUniqueCharacters(String a, String b) {
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < a.length(); i++)
        set.add(a.charAt(i));

    for (int i = 0; i < b.length(); i++)
        set.remove(b.charAt(i));

    for (Character c : set)
        System.out.print(c);
}

void printCharacterCount(String a) {
    Map<Character, Integer> map = new TreeMap<Character, Integer>();

    for(int i = 0; i < a.length(); i++) {
        char c = a.charAt(i);
        if(!map.containsKey(c))
            map.put(c, 0);

        map.put(c, map.get(c) +1);
    }

    for(char c : map.keySet()) {
        System.out.print(map.get(c) + "" + c);
    }
}
}