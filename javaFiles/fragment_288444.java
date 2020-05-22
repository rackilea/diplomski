{
   "$and": [
    {"$or": [
          {
         "user": {
            "$exists": true
         }
          },
          {
         "parent": {
            "$exists":true
         }
          }
       ]},
       {"$or": [
          {
         "car.id": 3846,
         "car.mediaType": 1
          },
          {
         "car.matched.id": 3846,
         "car.matched.model": 1
          }
      ]}
    ],
   "working": 1
}