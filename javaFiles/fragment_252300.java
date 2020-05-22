POST /test
{
    "mappings": {
        "book": {
            "_parent": {
                "type": "author"
            },
            "properties":{
                "category":{
                    "type":"string",
                    "fields":{
                        "raw":{
                            "type":"string",
                            "index": "not_analyzed"
                        }
                    }
                }
            }
        }
    }
}