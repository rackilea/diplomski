[
  { "$project": {
    "data1": 1,
    "result": {
      "$cond": {
        "if": { "$eq": [ "$salary", 250000 ] },
        "then": 30,
        "else": 20
      }
    }
  }}
]