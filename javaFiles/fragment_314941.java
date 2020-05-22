db.exp.aggregate([{"$unwind":"$show"},
 {"$unwind":"$show.season"},
 {"$unwind":"$show.season.episodes"},
 {"$match" : {"show.season.episodes.questionEntry.metaTags":{"$in": 
   ["Trivia"]}}},
 {"$group":{"_id":"$_id","episodes":{"$push":"$show.season.episodes"}
]);