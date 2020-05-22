{
"index": {
    "analysis": {
        "tokenizer": {
            "ngram_tokenizer": {
                "type": "ngram",
                "min_gram": 3,
                "max_gram": 10
            }
        },
        "analyzer": {
            "ngram_tokenizer_analyzer": {
                "type": "custom",
                "tokenizer": "ngram_tokenizer",
                "filter": [
                    "lowercase",
                    ...
                ]
            }
        }
    }
}