PUT /my_index
{
    "mappings": {
        "type1" : {
            "properties" : {
                "tokens" : {
                    "type" : "nested"
                }
            }
        }
    }
}