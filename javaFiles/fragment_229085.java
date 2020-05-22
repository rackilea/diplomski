db.user.aggregate(
    [
        { $match : {  id : "11" } },
        { $group : { _id : "$id", name : { $addToSet : "$name" } } }

    ])