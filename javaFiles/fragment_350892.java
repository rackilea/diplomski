public static void main(String a[]) {
    String[] strArr = { "one", "two", "three", "four", "four", "five" };
    HashSet<String> unique = new HashSet<String>();

    for (String str : strArr) {
        if (! unique.add(str)) {
            System.out.println("Duplicate Entry is: " + str);
        }
    }
}