private static final Pattern AND_PATTERN = Pattern.compile(" and ", Pattern.LITERAL);
...
    Matcher matcher = PATTERN .matcher(me);
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        matcher.appendReplacement(sb, ", ");
    }
    matcher.appendTail(sb);
    String changes = sb.toString();