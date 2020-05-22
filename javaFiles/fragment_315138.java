public void testHitsWithHitPositionCollector() throws Exception
{
    System.out.println(" .... testHitsWithHitPositionCollector");
    String fuzzyStr = "bro*";

    QueryParser parser = new QueryParser(Version.LUCENE_30, "f", analyzer);
    Query fzyQry = parser.parse(fuzzyStr);
    TopDocs hits = searcher.search(fzyQry, 10);

    QueryScorer scorer = new QueryScorer(fzyQry, "f");

    HitPositionCollector myFormatter= new HitPositionCollector();

    //Highlighter(Formatter formatter, Scorer fragmentScorer)
    Highlighter highlighter = new Highlighter(myFormatter,scorer);
    highlighter.setTextFragmenter(
        new SimpleSpanFragmenter(scorer)
    );

    Analyzer analyzer2 = new SimpleAnalyzer();

    int loopIndex=0;
    //for (ScoreDoc sd : hits.scoreDocs) {
        Document doc = searcher.doc( hits.scoreDocs[0].doc);
        String title = doc.get("f");

        TokenStream stream = TokenSources.getAnyTokenStream(searcher.getIndexReader(),
                                    hits.scoreDocs[0].doc,
                                    "f",
                                    doc,
                                    analyzer2);

        String fragment = highlighter.getBestFragment(stream, title);

        System.out.println(fragment);
        assertEquals("the quick brown fox jumps over the lazy dog", fragment);
        MatchOffset mo= myFormatter.getMatchList().get(loopIndex++);

        assertTrue(mo.getEndPos()==15);
        assertTrue(mo.getStartPos()==10);
        assertTrue(mo.getToken().equals("brown"));
}