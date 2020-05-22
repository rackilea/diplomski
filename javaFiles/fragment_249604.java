private static final Pattern TAG_REGEX = Pattern.compile("Order No(.+?) ");

    private static List<String> getOrderNo(final String str) {
        final List<String> tagValues = new ArrayList<String>();
        final Matcher matcher = TAG_REGEX.matcher(str);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }