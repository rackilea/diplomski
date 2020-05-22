db.b.find({
    $or : [{
        occupied : null
    }, {
        occupied : {
            $not : {
                $elemMatch : {
                    $gte : start,
                    $lte : end
                }
            }
        }
    }]
}).pretty();