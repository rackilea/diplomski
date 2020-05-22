Matcher m = pattern.matcher(myString);
StringBuilder out = new StringBuilder();
int pos = 0;
while (m.find()) {
    out.append(myString, pos, m.start());
    String matchedWord = m.group(1);
    String replacement = matchedWord.replaceAll(".", "*");
    out.append(replacement);
    pos = m.end();
}
out.append(myString, pos, myString.length());
myString = out.toString();