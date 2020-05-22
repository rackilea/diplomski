db.tools.aggregate([{
    "$match": {
        "madeInCountry": "germany"
    }
}, {
    "$unwind": "$usedIn"
}, {
    "$lookup": {
        "from": "cars",
        "localField": "usedIn.carId",
        "foreignField": "_id",
        "as": "usedIn.car"
    }
}, {
    "$unwind": "$usedIn.car"
}, {
    "$match": {
        "usedIn.car.madeInCountry": "germany"
    }
}, {
    "$group": {
        _id: "$_id",
        usedIns: {
            "$push": "$usedIn"
        }
    }
}])