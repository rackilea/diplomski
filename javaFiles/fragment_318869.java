public static void main(String[] args) {

    String[] input = new String[]{"foo/*comment*/bar", "comm*/foobar/*ent", "comment*/foobar", "foobar/*comment"};
    String pattern = "(?:/\\*[^\\*]+(?:\\*/)?|(?:/\\*)?[^\\*]+\\*/)";

    List<String> listMatches = new ArrayList<String>();
    String result = "";
    for (String m : input) {
        result = m.replaceAll(pattern, ""); //remove matches
        listMatches.add(result); // append to list
        System.out.println(result);
    }
}