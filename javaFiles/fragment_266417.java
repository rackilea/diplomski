String line = "Not a comment\n* This is a comment\n*This is also a comment\n";
line += "Not a * comment.";
String pattern = "^\\*.*$";

Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);
Matcher m = r.matcher(line);

while (m.find( )) {
    System.out.println("Found value: " + m.group(0) );
}

Found value: * This is a comment
Found value: *This is also a comment