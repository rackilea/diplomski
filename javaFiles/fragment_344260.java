POST /test_index/_search
{
    "query": {
        "filtered": {
            "query": {
                "match_all": {}
            },
            "filter": {
                "or": {
                    "filters": [
                        { "and": [
                            { "term": { "userid": { "value": "1" } } },
                            { "term": { "order": { "value": "A" } } }
                        ]},
                        { "and": [
                            { "term": { "userid": { "value": "2" } } },
                            { "term": { "order": { "value": "B" } } }
                        ]}
                    ]
                }
            }
        }
    }
}