curl -XDELETE localhost:9200/test
curl -XPUT localhost:9200/test -d '{
    "settings": {
        "index.number_of_shards": 1,
        "index.number_of_replicas": 0
    },
    "mappings": {
            "car": {
                "properties": {
                    "creators" : {
                        "type": "nested",
                        "properties": {
                            "name": {"type":"string"}
                        }
                    }
                }
            }
        }
    }
}
'
curl -XPOST localhost:9200/test/car/1 -d '{
    "creators": {
        "name": "Steve"
    }
}
'
curl -X POST 'http://localhost:9200/test/_refresh'
echo
curl -X GET 'http://localhost:9200/test/car/_search?pretty' -d '    {
    "query": {
        "nested": {
            "path": "creators",
            "query": {
                "bool": {
                    "must": [{
                        "match": {
                            "creators.name": "Steve"
                        }
                    }],
                    "must_not": [],
                    "should": []
                }
            }
        }
    },
    "from": 0,
    "size": 50,
    "sort": [],
    "facets": {}
}
'