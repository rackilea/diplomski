db.gasStation.aggregate([
{ "$match" : {
    "_id" : {
        "coordinate" : {
            "latitude" : 532144 ,
            "longitude" : -33333} ,
            "margin" : "N"
        }
}},
{ "$unwind" : "$prices"},
{ "$match" : {
    "prices.date" : {
        "$gte" : ISODate("2014-05-02T23:00:00.000Z") ,
        "$lte" : ISODate("2014-05-03T22:59:59.999Z")
    }
}}

], {explain:true});