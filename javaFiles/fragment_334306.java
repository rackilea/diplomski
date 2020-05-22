String text = "Hello bob, remind me to do a lot of things today";
final Pattern pattern = Pattern.compile("remind.*\\hto\\h");
Matcher m = pattern.matcher(text); // create it only once
// Looking for "remind <anyWord> to "
if (m.find()) {
    System.err.println( "Start: " + m.start() + ", match: " + m.group() );
}