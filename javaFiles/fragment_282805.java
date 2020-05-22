[
  { "$project": {
    "data1": 1,
    "result": {
      "$cond": [
        { "$eq": [ "$salary", 250000 ] },
        30,
        20
      }
    }
  }}
]