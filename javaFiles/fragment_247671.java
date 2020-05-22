db.collection.aggregate([
    // Using the index that was created
    { "$match": {
        "timestamp": { 
           "$gte": new Date("2014-04-01"), "$lt": new Date("2014-05-01")
        },
        "userId": { "$gte": "lowervalue", "$lte: "uppervalue" }
    }},

    // Grouping Data
    { "$group": {
        "_id": {
            "y": { "$year": "$timestamp" },
            "m": { "$month": "$timestamp" },
            "d": { "$day": "$timestamp" }
        },
        "someField": { "$sum": "$someField" },
        "otherField": { "$avg": "$otherField" }
    }}
])