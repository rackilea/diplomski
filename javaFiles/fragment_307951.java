public static List<String> split(String str, char splitChar, int afterOccurrences) {
    List<String> lst = new ArrayList<>();
    int occurrencesSeen = 0;
    int start = 0;
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (ch == splitChar) {
            occurrencesSeen++;
            if (occurrencesSeen >= afterOccurrences) {
                lst.add(str.substring(start, i));
                start = i + 1;
                occurrencesSeen = 0;
            }
        }
    }
    if (start < str.length() - 1)
        lst.add(str.substring(start));
    return lst;
}

public static void main(String[] args) {
    String str = "USA*2*Japan*8^2*India*5^4^2*Germany*5";
    System.out.println(split(str, '*', 2));
}