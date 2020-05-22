db.test.updateOne(
   { _id: ObjectId("5e37dc262f5ff4dfc935eb6b") }, 
   { 
     $set: { "session.ps.$[elem].apn": "newVal" }
     $push: { "session.ps.$[elem].d" : "gua" } 
   },
   {
     arrayFilters: [ { "elem.apn": "abcdef" } ]
   }
)