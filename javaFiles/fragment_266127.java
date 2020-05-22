String rawQuery = "name:abc AND age:26";
QueryParser parser = new QueryParser(Version.LUCENE_45, null, new WhitespaceAnalyzer(Version.LUCENE_45));
BooleanQuery query = (BooleanQuery) praser.parse(rawQuery);
query.clauses().get(0).setQuery(new TermQuery(new Term("name", "abcmodified")));
query.clauses().get(1).setQuery(new TermQuery(new Term("userage", "26")));
System.out.println(query);