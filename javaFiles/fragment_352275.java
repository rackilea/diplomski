List<String> strs = Arrays.asList("{[TEST}", "{[} {[BEST}", "bla {[} {[FEST}", "TEST","{[} {[FEST", "bla {[} hi {[} TEST} {[}");
for (String str : strs)
{
    Matcher m = Pattern.compile("\\{\\[[^}]*}|(TEST|BEST|FEST)").matcher(str);
    StringBuffer result = new StringBuffer();
    while(m.find()) {
        if (m.group(1) != null) {
            m.appendReplacement(result, "NEW_"+m.group(1));
        } else {
            m.appendReplacement(result, m.group(0));
        }
    }
    m.appendTail(result);
    System.out.println(result.toString());
}