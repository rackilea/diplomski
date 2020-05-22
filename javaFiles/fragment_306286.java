for (int i = 0; i < 10_000_000; i++) {
    Set<String> set = Collections.emptySet();
    for (String s : set) {
        System.out.println(s);
    }
}