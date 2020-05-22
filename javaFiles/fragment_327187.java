public static void main(String[] args) {
    List<String> ls = new ArrayList<String>(); // use ToDo instead of String here
    ls.add("a");
    ls.add("b");
    ls.add("c");
    for (String s : ls) {
        System.out.println(s);
    }
}