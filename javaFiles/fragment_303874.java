static ArrayList<String> permutations = new ArrayList<String>();

public static void main(String[] args) {
    ArrayList<String> letterArray = new ArrayList<String>();
    letterArray.add("w");
    letterArray.add("h");
    letterArray.add("a");
    letterArray.add("t");
    wordFinder(new ArrayList<String>(), letterArray);
    System.out.println(Arrays.asList(permutations));
}

public static void wordFinder(ArrayList<String> sub,
        ArrayList<String> letterArray) {
    permutations.add(sub.toString());
    if (letterArray.size() != 0) {
        for (int i = 0; i < letterArray.size(); i++) {
            ArrayList<String> prefix = new ArrayList<String>(sub);
            prefix.add(letterArray.get(i));
            ArrayList<String> postfix = new ArrayList<String>(letterArray);
            postfix.remove(i);
            wordFinder(prefix, postfix);
        }
    }
}