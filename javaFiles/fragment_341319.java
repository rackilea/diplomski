String input = "The quick brown bbb fox jumps over the aaaaaa lazy dog zzz.";

String longest = "";
String pattern = "(.)(\\1)+";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);

while (m.find()) {
    if (m.group(0).length() > longest.length()) {
        longest = m.group(0);
    }
}

System.out.println("Longest sequence: " + longest);

Longest sequence: aaaaaa