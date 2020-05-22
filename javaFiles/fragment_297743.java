curl -XPUT localhost:9200/my_index/data/_mapping -d '{
    "properties": {
        "category": {
            "type": "string",
            "fields": {
                "raw": {
                    "type": "string",
                    "index": "not_analyzed"
                }
            }
        }
    }
}'