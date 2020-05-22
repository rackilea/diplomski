[
    { "$group": {
        "_id": { "place_id": "$place_id", "user_id": "$user_id" }
    }},
    { "$group": {
        "_id": "$_id.place_id",
        "distinctUserCount": { "$sum": 1 }
    }}
]