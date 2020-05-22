db.getCollection('student').aggregate([
  { "$group": {
    "_id": null,
    "countFiteen": { 
      "$sum": {
        "$cond": [{ "$eq": [ "$student_age", 15 ] }, 1, 0 ]
      }
    },
    "countNotFifteen": {
      "$sum": {
        "$cond": [{ "$ne": [ "$student_age", 15 ] }, 1, 0 ]
      }
    },
     "sumNotFifteen": {
      "$sum": {
        "$cond": [{ "$ne": [ "$student_age", 15 ] }, "$student_age", 0 ]
      }
    }
  }}
])