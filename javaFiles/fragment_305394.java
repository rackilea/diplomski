db.collection.aggregate({
    $match: {
    "SessionTimeStamp.Start": {
        $gte: ISODate("2015-06-02T05:36:49.045Z")
    },
    "SessionTimeStamp.End": {
        $lte: ISODate("2015-06-02T05:36:56.045Z")
    }
    }
}, {
    $unwind: "$Actions"
}, {
    $group: {
    "_id": {
        "AppName": "$AppName",
        "Type": "$Actions.Type"
    },
    "count": {
        "$sum": "$Actions.Count"
    },
    "appCount": {
        $sum: 1
    }
    }
}, {
    $project: {
    "AppName": "$_id.AppName",
    "Type": "$_id.Type",
    "count": 1,
    "appCount": 1,
    "_id": 0
    }
})