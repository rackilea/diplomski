public class WebSearchQueryParser extends QueryParser {

    public WebSearchQueryParser(String f, Analyzer a) {
        super(f, a);
    }

    protected Query getRangeQuery(final String field, final String min, final String max,
            final boolean startInclusive, final boolean endInclusive) throws ParseException {
        if ("cost".equals(field)) {
            return NumericRangeQuery.newDoubleRange(field, Double.parseDouble(min), Double.parseDouble(max),
                    startInclusive, endInclusive);
        }
        return super.getRangeQuery(field, min, max, startInclusive, endInclusive);
    }
}