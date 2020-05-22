String[] wordList = { "Hello", "Namshte", "Hi", "Hey", ...... 500 words };

StringBuilder buf = new StringBuilder();
for (String word : wordList) {
    if (buf.length() != 0)
        buf.append('|');
    buf.append(Pattern.quote(word));
}
Pattern regex = Pattern.compile("\\.\\s((?i:" + buf + ")\\b[^.]+\\.)");

String text = "This is 1st Sentence. This is 2nd place. Hello,This is my 3rd Sentence." +
              " This is 4th place. Namshte, at 5.";
Matcher m = regex.matcher(text);
while (m.find())
    System.out.println("Found: " + m.group(1));