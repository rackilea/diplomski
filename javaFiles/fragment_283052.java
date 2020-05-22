DELETE /yourIndex/yourType/_query
{
    "query": {
        "filtered": {
            "query": {
                "term": {
                    "messageId": "13"
                }
            },
            "filter": {
                "not": {
                    "term": {
                        "_id": 1
                    }
                }
            }
        }
    }
}