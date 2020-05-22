String p = "(?m)(?:\\G(?!\\A)[^\\S\r\n]+|^Main\\s*:\\s*)(\\S+)\r?\n?";
String s = "Preface (optional, up to multiple lines)...\nMain : sequence1\n   sequence2\n   sequence3\n   sequence4\nEpilogue (optional, up to multiple lines)";
Matcher m = Pattern.compile(p).matcher(s);
while(m.find()) {
    System.out.println(m.group(1));
}