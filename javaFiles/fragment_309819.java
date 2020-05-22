String input = "The quick brown fox jumps over the lazy dog";
Matcher matcher = Pattern.compile("e").matcher(input);

while ( matcher.find() ) {
    // Do something with the matched text
    System.out.println(matcher.group(0));
}