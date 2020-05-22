{
    "name": “MyMessageWithEncryptedField”,
    "type": "record",
    "fields": [
        {"name": "payload","type" : {"type" : "bytes","logicalType" : "encrypted"}},
        ...