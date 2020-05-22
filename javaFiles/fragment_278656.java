PUT /crawlbot
{
    "settings": {
        "analysis": {
            "analyzer": {
                "url_analyzer": {
                    "type":         "custom",
                    "tokenizer":    "keyword",
                    "filter":       [ "lowercase" ]
                }
            }
        }
    },
    "mappings": {
        "article": {
            "properties": {
                "article": {
                    "url": {
                        "type": "string",
                        "analyzer": "url_analyzer"
                    }
                }
            }
        }
    }
}