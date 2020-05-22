public static Map<String, String> match(final String pattern, final String text)  {
    final StringBuilder regexp = new StringBuilder("^");

    final List<String> varNames = new LinkedList<String>();
    int i=0;
    for (final String subPart : pattern.split("%", -1)) {
        if (i++%2!=0) {
            regexp.append("(.*)");
            varNames.add(subPart);
        } else {
            regexp.append(Pattern.quote(subPart));
        }
    }
    regexp.append("$");

    final Pattern p = Pattern.compile(regexp.toString());
    final Matcher m = p.matcher(text);


    final Map<String, String> matched = new HashMap<String, String>();
    if (m.matches()) {
        int j=1;
        for (final String varName : varNames) {
            matched.put(varName, m.group(j++));
        }
    }

    return matched;
}