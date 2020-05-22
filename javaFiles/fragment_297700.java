import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

private static final Map<String, Character> keyMap = new HashMap<String, Character>(); // store key and value
private static final Set<Character> vowelSet = new HashSet<Character>(); // store vowel in set

static {
    keyMap.put("and", '&');
    keyMap.put("to", '2');
    keyMap.put("you", 'u');
    keyMap.put("for", '4');

    vowelSet.add('a');
    vowelSet.add('e');
    vowelSet.add('i');
    vowelSet.add('o');
    vowelSet.add('u');
}

public static void main(String[] args) {
    System.out.println(shortHand("For I shall love you forever"));
}

public static String shortHand(String str) {
    StringBuffer result = new StringBuffer();
    String[] strArr = str.split(" "); //seperate string  by the space
    for (int i = 0; i < strArr.length; i++) {
        String temp = strArr[i].toLowerCase();
        if (keyMap.containsKey(temp)) {//check in map eg. does it contains in the map then replace it with shorthand word.
            result.append(keyMap.get(temp));
            result.append(" ");
        } else {
            if (temp.length() == 1 && vowelSet.contains(temp.charAt(0))) {//if it is only a vowel
                result.append(temp);
                result.append(" ");
            } else {
                for (int j = 0; j < temp.length(); j++) {//check in every character if its vowel or not
                    if (!vowelSet.contains(temp.charAt(j))) {
                        result.append(temp.charAt(j));
                    }
                }
                result.append(" ");
            }
        }

    }
    return result.toString();
}
}