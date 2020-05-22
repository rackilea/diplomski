curl -X POST http://localhost:9200/geotiff_test/geometa/_search -d '{
    "query": {
        "term": {
            "thumbnail.keyword": "thumbnail1536.png"
        }
    }
}'