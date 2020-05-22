public static void main(String[] args) {
    final String myString = "< value1 >,< value2 >, <1,2,3,4,5>,< some value >";
    final Pattern pattern = Pattern.compile("(?<=<)[^>]++(?=>)");
    final Matcher m = pattern.matcher(myString);
    while(m.find()) {
        System.out.println(m.group().trim());
    }
}