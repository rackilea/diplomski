db.getCollection("1dag").find({
    "timestamp": {
        "$gte": 1412204098,
        "$lte": 1412204099
    }
})