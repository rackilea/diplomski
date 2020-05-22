String s = "This text was just made RANDOMLY to show what I MEANT.";

Pattern p = Pattern.compile("\\b[A-Z]{4,}\\b");
Matcher m = p.matcher(s);
while (m.find()) {
    String word = m.group();
    System.out.println(word);
}