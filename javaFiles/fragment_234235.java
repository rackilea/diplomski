db.player.aggregate([
    {$match:{ "id_device" : "machine1"}},
    {$unwind: "$games"},
    {$match:{ "games.gamename" : "PPA"}},
    {$group: {_id:{"_id":"$_id", "my_id":"$my_id", "id_device":"$id_device","language":"$language"}, "games" : {$push:"$games"}}},
    {$project: {"_id":"$_id._id", "my_id":"$_id.my_id", "id_device": "$_id.id_device", "language":"$_id.language", "games":"$games"}}
])