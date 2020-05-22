public static void main(String[] args) {
    InstrumentedSet<String> s = new InstrumentedSet<String>(
                new HashSet<String>());
    s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    System.out.println(s.getAddCount());
}