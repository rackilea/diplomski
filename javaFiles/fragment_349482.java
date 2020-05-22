String input = "Hello world!!!:)";

Pattern p = Pattern.compile("(\w+)|(!)|(:\))");
Matcher m = p.matcher(input);

List<String> matches = new ArrayList<String>();
while (m.find()) {
    matches.add(m.group());
}