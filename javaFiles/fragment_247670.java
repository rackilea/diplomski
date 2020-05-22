db.collection.ensureIndex({ 
    "timestamp": 1, "userId": 1
})

db.collection.ensureIndex({
    "timestamp": 1, "applicationName": 1, "country": 1
})