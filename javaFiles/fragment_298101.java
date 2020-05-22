public static String deDuplicate(char[] inpt) {
    Set<Character> already_seen_chars = new HashSet<Character>();
    String result = "";

    for(int i = 0; i < inpt.length; i++) {
        if(!already_seen_chars.contains(inpt[i])) { // Is the character already contained in the set?
            result += Character.toString(inpt[i]);
            already_seen_chars.add(inpt[i]);
        }
    }

    return result;
}

public static void main(String[] args) {
    String test = "ttttteeeeesssstttt";
    System.out.println(deDuplicate(test.toCharArray()));
}