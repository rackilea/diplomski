BoolQueryBuilder keywordBuilder = boolQuery();
keywords.forEach(k -> keywordBuilder.should(matchPhraseQuery("text", k)));

BoolQueryBuilder stopWordBuilder = boolQuery();
stopWords.forEach(s -> stopWordBuilder.should(matchPhraseQuery("text", s)));

BoolQueryBuilder queryBuilder = boolQuery()
        .must(keywordBuilder)
        .mustNot(stopWordBuilder);          

Page<Result> results= elRepository.search(queryBuilder, pageable);