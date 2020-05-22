public static void main(String[] args) {
    final String str = "<tag>apple</tag><b>hello</b><tag>orange</tag><tag>pear</tag>";
    System.out.println(Arrays.toString(getTagValues(str).toArray())); // Prints [apple, orange, pear]
}

private static final Pattern TAG_REGEX = Pattern.compile("<tag>(.+?)</tag>", Pattern.DOTALL);

private static List<String> getTagValues(final String str) {
    final List<String> tagValues = new ArrayList<String>();
    final Matcher matcher = TAG_REGEX.matcher(str);
    while (matcher.find()) {
        tagValues.add(matcher.group(1));
    }
    return tagValues;
}