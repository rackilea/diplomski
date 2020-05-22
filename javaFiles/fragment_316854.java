db.test.aggregate([
    { "$match": { "filePrefix": { "$in": docsSet }  } },
    { "$sort": { "filePrefix": 1, "fileId": -1 } },
    { 
        "$group": {
            "_id": "$filePrefix",
            "fileId": { "$first": "$fileId"},
            "fileName": { "$first": "$fileName"}
        }
    }
])