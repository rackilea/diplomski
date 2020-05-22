List<String> strs = Arrays.asList("{[TEST}", "{[} {[BEST}", "bla {[} {[FEST}", "TEST","{[} {[FEST", "bla {[} hi {[} TEST} {[}");
for (String str : strs)
{
    Matcher m = Pattern.compile("\\{\\[[^}]*}|(TEST|BEST|FEST)").matcher(str);
    while(m.find()) {
        if (m.group(1) != null) {
            System.out.println(m.group(1) + " found in '" + str + "'");
        }
    }
}