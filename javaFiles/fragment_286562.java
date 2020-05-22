String[][] mda = {{"Hello ma", "3"},
        {"How r u?", "2"},
        {"i m fine", "5"}};

public void test() {
    System.out.println(Arrays.deepToString(mda));
    Arrays.sort(mda, Comparator.comparing(s -> s[1]));
    System.out.println(Arrays.deepToString(mda));
}