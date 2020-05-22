db.getCollection('my_collection').aggregate([
    {
        $group:{
            "_id": "$uniqueVal",
            document:{
                $first:"$$ROOT"
            }
        }
    }
])