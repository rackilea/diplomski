class RangeFactory {

    private static final Pattern p = Pattern.compile("^[\\(|\\[](\\d+),(\\d+)[\\)|\\]]$");

    public static Range from(String range) {
        Matcher m = p.matcher(range);
        if(m.matches()) {
            int length = range.length();

            int lowerBound = Integer.parseInt(m.group(1));
            int upperBound = Integer.parseInt(m.group(2));

            if(range.charAt(0) == '(') {
                if(range.charAt(length - 1) == ')') {
                    return Range.open(lowerBound, upperBound);
                }
                return Range.openClosed(lowerBound, upperBound);
            } else {
                if(range.charAt(length - 1) == ')') {
                    return Range.closedOpen(lowerBound, upperBound);
                }
                return Range.closed(lowerBound, upperBound);
            }
        }
        throw new IllegalArgumentException("Range " + range + " is not valid.");
    }
}