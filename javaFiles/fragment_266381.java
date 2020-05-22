BooleanQuery bq = new BooleanQuery();
BooleanQuery entryBQ = new BooleanQuery();
BooleanQuery descriptionBQ = new BooleanQuery();
String[] tokens = String.valueOf(s).split("[^a-zA-Z0-9]");
for (String token : tokens) {
    if (token.isEmpty()) continue;
    entryBQ.add(new WildcardQuery(new Term("entry", token + "*")), BooleanClause.Occur.MUST);
    descriptionBQ.add(new WildcardQuery(new Term("description", token + "*")), BooleanClause.Occur.MUST);
}
bq.add(entryBQ, BooleanClause.Occur.SHOULD);
bq.add(descriptionBQ, BooleanClause.Occur.SHOULD);
TopScoreDocCollector collector = TopScoreDocCollector.create(10, true);
is.search(bq, collector);