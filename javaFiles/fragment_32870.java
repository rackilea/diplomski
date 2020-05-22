public void test() {
    List<String> strs = Arrays.asList(new String[]{"DEF", "ABC", "JKL", "GHI", "ABC", "DEF", "JKL", "MNO", "GHI", "ABC", "MNO", "JKL"});
    // All these are special and should appear at the front of the list.
    Set<String> specials = new HashSet<>(Arrays.asList("ABC", "JKL"));
    strs.sort((String o1, String o2) -> {
        if (specials.contains(o1) == specials.contains(o2)) {
            // Both special or both normal - just compare.
            return o1.compareTo(o2);
        } else if (specials.contains(o1)) {
            // First is special!
            return -1;
        } else {
            // Second is special.
            return 1;
        }
    });
    System.out.println(strs);
}