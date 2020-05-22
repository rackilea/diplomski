BasicDBObject.parse("
  {'$eq':[
     {'$subtract':[
       {'$ifNull':['$acceptedDate',{'$date':" + System.currentTimeMillis() + "}]},
       {'$subtract':['$lastVisit', 216000000]} // 5 days
     ]}, 
     432000000 // 10 days
  ]}"
);