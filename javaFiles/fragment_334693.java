[
    { "$group": {
        "_id": {
            "year": { "$year": "$dateSold" },
            "quarter": {
                "$add": [
                    { "$subtract": [
                        { "$divide": [{ "$subtract": [{ "$month": "$dateSold" },1]},3]},
                        { "$mod": [
                            { "$divide": [{ "$subtract": [{ "$month": "$dateSold" },1]},3]},
                            1
                        ]}
                    ]},
                    1
                ]
            }
        },
        "unitsSold": { "$sum": "$unitsSold" }
    }}
]