public static void main(String[] args) {
    Set<String> strs = new HashSet<String>();
    strs.add("one");
    strs.add("two");
    strs.add("three");

    for (String str : strs) {
        //note the typo: twos is NOT in the set
        if (str.equalsIgnoreCase("twos")) {
            strs.remove(str);
        }
    }
}