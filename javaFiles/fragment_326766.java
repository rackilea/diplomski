public class CustomMultiFieldQueryParser extends MultiFieldQueryParser {

    public CustomMultiFieldQueryParser(Version matchVersion, String[] fields, Analyzer analyzer) {
        super(matchVersion, fields, analyzer);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected org.apache.lucene.search.Query getRangeQuery(String fieldName, String min, String max, boolean minInclusive,
            boolean maxInclusive) throws ParseException {
        // TODO Auto-generated method stub
        if(fieldName.equals("price")) {
            return NumericRangeQuery.newLongRange(fieldName, Long.parseLong(min), Long.parseLong(max), minInclusive, maxInclusive);
        }
        return super.getRangeQuery(fieldName, min, max, minInclusive, maxInclusive);
    }
}