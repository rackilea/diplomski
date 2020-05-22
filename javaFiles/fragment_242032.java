//double brace initialization
private static final Set<String> FRUITS = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER) {{
    this.add("Apple");
    this.add("Banana");
    this.add("Orange");
    this.add("PineApple");
    this.add("banana");
}};

//Or a static block
static {
    FRUITS.add("Apple");
    FRUITS.add("Banana");
    FRUITS.add("Orange");
    FRUITS.add("PineApple");
    FRUITS.add("banana");
}