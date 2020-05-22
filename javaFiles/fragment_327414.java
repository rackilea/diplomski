List<String> ranges =
    Arrays.asList("(0,100)", "[0,100]", "[0,100)", "(0,100]", "", "()", "(0,100", "[,100]", "[100]");

for(String range : ranges) {
    try {
        System.out.println(RangeFactory.from(range));
    } catch (IllegalArgumentException ex) {
        System.out.println(ex);
    }
}