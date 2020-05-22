keys.add(FullTextIndexationManager.FULLTEXT_COL);
    values.add(QueryParser.escape(value));
    occurs.add(BooleanClause.Occur.SHOULD);
    //exact search
    keys.add(FullTextIndexationManager.EXACT_COL+FullTextIndexationManager.FULLTEXT_COL);
    values.add(QueryParser.escape(value));
    occurs.add(BooleanClause.Occur.SHOULD);
    Query q = MultiFieldQueryParser.parse(Version.LUCENE_44, queries, fields, flags, ontologySearch.getAnalyzer());