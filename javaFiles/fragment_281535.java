"definitions": {
    "Obj": {
        "type": "object",
        "properties": {
            "date": {
                "type": "string",
                "format": "date-time",
                "readOnly": true
            },
            "rate": {
                "type": "integer",
                "format": "int32"
            },
            "user": {
                "type": "string",
                "readOnly": true
            }
        }
    }
}