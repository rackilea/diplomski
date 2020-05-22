BooleanQuery.Builder finalQuery = new BooleanQuery.Builder();
BooleanQuery.Builder q1 = new BooleanQuery.Builder();
q1.add(new TermQuery(new Term("f1", "x")), Occur.SHOULD);
q1.add(new TermQuery(new Term("f2", "x")), Occur.SHOULD);
finalQuery.add(q1.build(), Occur.MUST);
finalQuery.add(new TermQuery(new Term("f3", "y")), Occur.MUST);
Query queryForSearching = finalQuery.build();