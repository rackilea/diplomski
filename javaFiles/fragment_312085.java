db.collection.aggregate([
    { $unwind: "$connects" },

    // count all occurrences
    { "$group": { "_id": {skill: "$skill", parser_id: "$connects.parser_id"}, "count": { "$sum": 1 } }},

    // sum all occurrences and count distinct
    { "$group": { "_id": "$_id.skill", "quantity": { "$sum": 1 } }},

    // (optional) rename the '_id' attribute to 'skill'
    { $project: { 'skill': '$_id', 'quantity': 1, _id: 0 } }
])