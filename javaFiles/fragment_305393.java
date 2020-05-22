db.collection.aggregate({
    $match: {
    "SessionTimeStamp.Start": ISODate("2015-06-02T05:36:49.045Z")
    }
}, {
    $group: {
    "_id": "AppName",
    "Document": {
        $push: {
            "SessionTimeStamp": "$SessionTimeStamp",
            "Actions": "$Actions",
            "AppName": "$AppName"
        }
    }
    }
}, {
    $unwind: "$Document"
}, {
    $unwind: "$Document.Actions"
}, {
    $group: {
    _id: "$Document.Actions.Type",
    "OrderCount": {
        $sum: "$Document.Actions.OrderCount"
    },
    "App": {
        $first: "$Document.AppName"
    }
    }
}, {
    $project: {
    "_id": 0,
    "OrderCount": 1,
    "ActionType": "$_id",
    "App": 1
    }
})