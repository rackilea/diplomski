{
    "stages" : [
        {
            "$cursor" : {
                "query" : {
                    "_id" : {
                        "coordinate" : {
                            "latitude" : 532144,
                            "longitude" : -33333
                        },
                        "margin" : "N"
                    }
                },
                "plan" : {
                    "cursor" : "IDCursor",
                    "indexBounds" : {
                        "_id" : [
                            [
                                {
                                    "coordinate" : {
                                        "latitude" : 532144,
                                        "longitude" : -33333
                                    },
                                    "margin" : "N"
                                },
                                {
                                    "coordinate" : {
                                        "latitude" : 532144,
                                        "longitude" : -33333
                                    },
                                    "margin" : "N"
                                }
                            ]
                        ]
                    }
                }
            }
        },
        {
            "$unwind" : "$prices"
        },
        {
            "$match" : {
                "prices.date" : {
                    "$gte" : ISODate("2014-05-02T23:00:00Z"),
                    "$lte" : ISODate("2014-05-03T22:59:59.999Z")
                }
            }
        }
    ],
    "ok" : 1