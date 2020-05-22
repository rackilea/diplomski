private static final Pattern PATTERN = Pattern.compile("-{2,}"); 

private static String fix(String string) {
    StringBuilder sb = new StringBuilder();
    Matcher m = PATTERN.matcher(string);
    int lastEnd = 0;
    while (m.find()) {
        System.out.println(m.group());
        sb.append(string.subSequence(lastEnd, m.start())).append('-');
        lastEnd = m.end();
        for (int i = lastEnd - m.start(); i > 1; i--) {
            sb.append(" -");
        }
    }
    if (lastEnd < string.length()) {
        sb.append(string.subSequence(lastEnd, string.length()));
    }
    return sb.toString();
}