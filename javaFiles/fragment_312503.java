FuzzyQuery query1 = new FuzzyQuery(new Term("field", "fuzy"));
FuzzyQuery query2 = new FuzzyQuery(new Term("field", "phrse"));
Query wrappedQuery1 = new SpanMultiTermQueryWrapper<FuzzyQuery>(query1);
Query wrappedQuery2 = new SpanMultiTermQueryWrapper<FuzzyQuery>(query2);
SpanQuery[] clauses = {wrappedQuery1, wrappedQuery2};
SpanNearQuery(clauses, 0, true);