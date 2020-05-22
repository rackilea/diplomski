db.collection.aggregate([
    { "$sort": { "snapshot": -1 } },
    {
        "$group": {
            "_id": "$id",
            "snapshot": { "$first": "$snapshot" },
            "name": { "$first": "$name" }
        }
    }
])