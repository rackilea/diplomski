public static String format(String input, String[] args) {
    StringBuffer sb = new StringBuffer();

    Matcher matcher = Pattern.compile("\\d+").matcher(input);
    while (matcher.find()) {
        int nr = Integer.parseInt(matcher.group());
        if (nr <= args.length) {
            matcher.appendReplacement(sb, Matcher.quoteReplacement(args[nr - 1]));
        }
    }

    matcher.appendTail(sb);

    return sb.toString();
}