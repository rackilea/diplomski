import java.util.Map;
import java.util.Stack;

public class CandidateCode 
{ 
public static int chainLength=0;
public static void main(String[] args) {
    String s= "peas,sugar,rice,soup";
    int chainLengthfinal=wordChain(s);
    System.out.println("final length:"+chainLengthfinal);
}
public static int wordChain(String input1)
{
    List<String> stringList = new ArrayList<String>();
    stringList= Arrays.asList(input1.split(","));
    boolean ischain = new CandidateCode().hasChain(stringList);
    if (ischain) {
     return chainLength;    
    }
    return 0;

}
Map<Character, List<String>> startsWith = new HashMap<Character, List<String>>();
Map<Character, List<String>> endsWith = new HashMap<Character, List<String>>();

private Character getFirstChar(String str) {
    return str.charAt(0);
}

private Character getLastChar(String str) {
    return str.charAt(str.length() - 1);
}

boolean hasChain(List<String> stringList) {
    for (String str : stringList) {
        Character start = getFirstChar(str);
        Character end = getLastChar(str);
        List<String> startsWithList;
        List<String> endsWithList;

        if (startsWith.containsKey(start)) {
            startsWithList = startsWith.get(start);
        } else {
            startsWithList = new ArrayList<String>();
            startsWith.put(start, startsWithList);
        }

        if (endsWith.containsKey(end)) {
            endsWithList = endsWith.get(end);
        } else {
            endsWithList = new ArrayList<String>();
            endsWith.put(end, endsWithList);
        }
        startsWithList.add(str);
        endsWithList.add(str);
    }

    Stack<String> stringStack = new Stack<String>();
    for (String str : stringList) {
        if (hasChain(stringList.size(), str, stringStack)) {
            System.out.println(stringStack);
            System.out.println("size "+stringStack.size());
            chainLength= stringStack.size();
            return true;
        }
    }

    return false;
}

private boolean hasChain(int size, String startString, Stack<String> stringStack) {
    if (size == stringStack.size()) return true;
    Character last = getLastChar(startString);
    if (startsWith.containsKey(last)) {
        List<String> stringList = startsWith.get(last);
        for (int i = 0; i < stringList.size(); i++) {
            String candidate = stringList.remove(i--);
            stringStack.push(candidate);
            if (hasChain(size, candidate, stringStack)) {
                return true;
            }
            stringStack.pop();
            stringList.add(++i, candidate);
        }
    }

    return false;
 }
}