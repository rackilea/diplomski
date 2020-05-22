db.scenarios.aggregate([
    { $match: { bid: "build_1481711758" } },
    { 
        "$group": {
            "_id": { 
                "bid": "$bid",
                "scst": "$scst"
            },
            "count": { "$sum": 1 }
        }
    },
    { 
        "$group": {
            "_id": "$_id.bid",
            "counts": {
                "$push": {
                    "scst": "$_id.scst",
                    "count": "$count"
                }
            }
        }
    }
])