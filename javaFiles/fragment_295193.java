GET /my_index/_search
{
    "size": 0,
    "aggs": {
        "keywords": {
            "nested": {
                "path": "keywords"
            },
            "aggs": {
                "keyword_name": {
                    "terms": {
                        "field": "keywords.keyword"
                    },
                    "aggs": {
                        "sums": {
                            "sum": {
                                "field": "keywords.count"
                            }
                        }
                    }
                }
            }
        }
    }
}