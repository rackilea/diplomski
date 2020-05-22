// 1. Check for documents which have curFlag true
var match = { "$match": { "curFlag": true } };

// 2. GroupBy owner and display the number of files that particular user is handling
var group = {
    "$group": {
        "_id": "$meta.owner",
        "count": { "$sum": 1 }
    }
};

// 3. Display the user who is handling large no. of files
var sort = { "$sort": { "count": -1 } },
    limit = { "$limit": 1 };

// Run pipeline
db.mycollection.aggregate([match, group, sort, limit])