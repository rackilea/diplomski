public static void main(String a[]) {
    String[] strArr = { "one", "two", "three", "four", "four", "five" };
    ArrayList<String> unique = new ArrayList<String>();

    for (String str : strArr) {
        if (unique.contains(str)) {
            System.out.println("Duplicate Entry is: " + str);
        } else {
            unique.add(str);
        }
    }
}