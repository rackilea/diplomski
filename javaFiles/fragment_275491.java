db.getCollection("employee_leads").aggregate([
{
        $match : {
            "_id" : new ObjectId("5d55ac30e533bc76e4581923") // This is in case you want to filter anything. 
        }
},
{
        $lookup : {
            "from": "employee",
            "localField": "leads",
            "foreignField": "_id",
            "as": "leads"
        }
}])