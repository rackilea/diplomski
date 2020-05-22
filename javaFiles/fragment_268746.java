IndexSearcher[] searchers = new IndexSearcher[2];
searchers[0] = new IndexSearcher(searchDirOne);
searchers[1] = new IndexSearcher(searchDirTwo);

MultiSearcher searcher = new MultiSearcher(searchers);

Query query = QueryParser.Parse("foo","bar" , new StandardAnalyzer());

Hits hits = searcher.Search(query);