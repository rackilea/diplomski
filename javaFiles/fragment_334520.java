List<String> elements = // initialize here
Set<String> prefixes = new HashSet<String>();
for( String element : elements) {
    String prefix = element.substring(0,"<prefix-n>".length());
    prefixes.add(prefix);
}
// Prefixes now has a unique set of prefixes.