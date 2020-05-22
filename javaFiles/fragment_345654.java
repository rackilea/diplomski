db.collection.aggregate([
    { $addFields: {
        matchedTags: { $size: { 
            $setIntersection: [ "$keywords", [ "java", "thread", "sleep" ] ] 
        } }
    } },
    { $match: { matchedTags: { $gt: 0 } } },
    { $sort: { matchedTags: -1 } }
])