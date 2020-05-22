db.scenarios.aggregate([
    { $match: { bid: "build_1481711758" } },
    {
        $group: {
            _id: "$bid",
            nb: { $sum: 1 },
            nbS: {
                "$sum": {
                    "$cond": [ "$scst",  1, 0 ]
                }
            },
            nbE: {
                "$sum": {
                    "$cond": [ "$scst",  0, 1 ]
                }
            }
        }
    }
])