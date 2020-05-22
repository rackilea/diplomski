String[] apples = {"one", "two.", "three"};
for (int index = 0; index < apples.length; index++) {
    String s = apples[index];
    while (s.contains(".")) {
        s = s.replace(".", "");
    }
    apples[index] = s;
}
for (String s : apples) {
    System.out.println(s);
}