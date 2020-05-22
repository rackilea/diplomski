db["temp"].aggregate([
 {$group:{
    _id:"$id",
    addresses : {$addToSet : "$address"}
    }
 },
 {$out : "persons"}
 ])