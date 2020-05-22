db.collection.aggregate([{
    $group: {
        _id: {
            "bannerUserSessionId": "$bannerUserSessionId",
            "bannerId": "$bannerId",
            "bannerEventLabel": "$bannerEventLabel",
            "bannerPage": "$bannerPage"
        },
        "bannerClickTimestamp": {
            $first: "$bannerClickTimestamp"
        }
    }
}])