String sentence = "I want to walk in the park with my father";

Pattern pattern = Pattern.compile("\\w+ \\w+ \\w+ ");
Matcher matcher = pattern.matcher(sentence);
while (matcher.find()) {
    System.out.println(matcher.group());
}