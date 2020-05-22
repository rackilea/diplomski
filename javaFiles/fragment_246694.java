// replaces up to N times with uppercase of matched text
static String replaceUppercase(int N, Matcher m) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++) {
        if (m.find()) {
            m.appendReplacement(
                sb,
                Matcher.quoteReplacement(m.group().toUpperCase())
            );
        } else {
            break;
        }
    }
    m.appendTail(sb);
    return sb.toString();
}