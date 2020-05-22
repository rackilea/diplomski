String block = "\\w+\\(\\?*\\w+(?:,\\?*\\w+)?\\)";
String pat = "(" + block + ")(," + block + ")*";
List<String> strs = Arrays.asList("a(b)", "a(?v)", "a(b),c(?c,a)");
for (String str : strs) {
    Matcher m = Pattern.compile(pat).matcher(str);
    while (m.find()) {
        System.out.println(m.group(0));
    }
}