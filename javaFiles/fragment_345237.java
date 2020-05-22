public class Int4RangeConverter implements Converter<Object, Range<Integer>> {
    private static final Pattern PATTERN = Pattern.compile("\\[(.*?),(.*?)\\)");

    @Override
    public Range<Integer> from(Object t) {
        if (t == null)
            return null;

        Matcher m = PATTERN.matcher("" + t);
        if (m.find())
            return Tuple.range(
                Integer.valueOf(m.group(1)), 
                Integer.valueOf(m.group(2)));

        throw new IllegalArgumentException("Unsupported range : " + t);
    }

    @Override
    public Object to(Range<Integer> u) {
        return u == null ? null : "[" + u.v1 + "," + u.v2 + ")";
    }

    @Override
    public Class<Object> fromType() {
        return Object.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Class<Range<Integer>> toType() {
        return (Class) Range.class;
    }
}