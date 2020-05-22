test = {
    settings.analysis.filter.keyword_search.type=edge_ngram,
    settings.number_of_shards=3,
    settings.analysis.analyzer.keyword.filter.0=lowercase,
    settings.analysis.analyzer.keyword.filter.1=keyword_search,
    settings.analysis.analyzer.keyword.type=custom,
    settings.analysis.analyzer.keyword.tokenizer=whitespace,
    settings.analysis.filter.keyword_search.max_gram=15,
    settings.analysis.filter.keyword_search.min_gram=3
}