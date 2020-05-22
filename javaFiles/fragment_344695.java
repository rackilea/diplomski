String termQueryString = "title:\"hello world\"";
Query termQuery = parser.parse(termQueryString);

Query pageQueryRange = NumericRangeQuery.newIntRange("page_count", 10, 20, true, true);

Query query = termQuery.combine(new Query[]{termQuery, pageQueryRange});