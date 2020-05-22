db.lineitems.aggregate([
    { "$match": { "shipdate": { "$lte": 19980801 } },
    { "$group": {
        "_id": {
            "returnflag": "$returnflag",
            "linestatus": "$linestatus"
        },
        "count": { "$sum": 1 },
        "sum_qty": { "$sum": "$quantity" },
        "avg_qty": { "$avg": "$quantity" },
        "sum_base_price": { "$sum": "$extendedprice" },
        "avg_base_price": { "$avg": "$extendedprice" },
        "sum_disc_price": {
            "$sum": {
                "$multiply": [
                    "$extendedprice",
                    { "$subtract": [ 1, "$discount" ] }
                ]
            }
        },
        "avg_disc_price": {
            "$avg": {
                "$multiply": [
                    "$extendedprice",
                    { "$subtract": [ 1, "$discount" ] }
                ]
            }
        },
        "sum_charge": {
            "$sum": {
                "$multiply": [
                    "$extendedprice",
                    { "$subtract": [ 1, "$discount" ] },
                    { "$add": [ 1, "$tax" ] }
                ]
            }
        },
        "avg_disc": { "$avg": "$discount" }
    }}
])