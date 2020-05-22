{
"YourType": {
    "dynamic": "true",
    "_id": {
        "path": "new_id"
    },
    "_timestamp": {
        "enabled": true,
        "store": true
    },
    "properties": {
        "new_id": {
            "type": "string",
            "fields": {
                "raw": {
                    "index": "not_analyzed",
                    "type": "string"
                }
            }
        }
    }
}