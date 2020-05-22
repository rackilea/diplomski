public static void main(String[] args) {
    List<String> newList = legacyMethod();

    for (String s : newList) {
        System.out.println(s);
    }
}

public static List legacyMethod() {
    List oldList = new ArrayList();
    oldList.add("a");
    oldList.add("b");
    oldList.add("c");
    return oldList;
}