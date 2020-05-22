public class MyTest {
    static class PlaceHolder {
        int index;
        String flags;
        Integer width;
        Integer precision;
        String type;
        String conversion;

        @Override
        public String toString() {
            return String.format("PlaceHolder[index=%s, conversion=%s, flags=%s, width=%s, precision=%s, type=%s]",
                    index, conversion, flags, width, precision, type);
        }
    }

    public List<PlaceHolder> getPlaceholders(String pattern) {
        // %[argument_index$][flags][width][.precision][t]conversion
        Pattern regex = Pattern.compile("%((\\d+)\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.(\\d+))?([tT])?([a-zA-Z%])");

        int nextImplicitIndex = 1;
        Matcher matcher = regex.matcher(pattern);

        List<PlaceHolder> placeholders = new ArrayList<PlaceHolder>();
        while (matcher.find()) {
            String sIndex = matcher.group(2);
            int index = sIndex == null ? nextImplicitIndex++ : Integer.parseInt(sIndex);
            String flags = matcher.group(3);
            String sWidth = matcher.group(4);
            String sPrecision = matcher.group(6);
            String type = matcher.group(7);
            String conversion = matcher.group(8);

            PlaceHolder placeholder = new PlaceHolder();
            placeholder.index = index;
            placeholder.flags = flags;
            placeholder.width = sWidth == null ? null : new Integer(sWidth);
            placeholder.precision = sPrecision == null ? null : new Integer(sPrecision);
            placeholder.type = type;
            placeholder.conversion = conversion;

            placeholders.add(placeholder);

        }
        return placeholders;
    }

    @Test
    public void testGetPlaceholders() {
        System.out.println(getPlaceholders("Integer is %d, String is %s"));
        System.out.println(getPlaceholders("String is %2$s, Integer is %1$d"));
        System.out.println(getPlaceholders("%,6.2f"));
        System.out.println(getPlaceholders("Today is %tB %te, %tY %n"));
    }
}