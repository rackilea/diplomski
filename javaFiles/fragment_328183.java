db.log.aggregate([
  { "$match": { 
      "ts": { 
        "$gte": ISODate("2015-07-31T18:30:00.000Z"),
        "$lt": ISODate("2015-08-01T18:30:00.000Z")  
      },
      "dup": { "$exists": false } 
  }},
  { "$group": {
    "_id": {
      "$add": [
        { "$subtract": [
          { "$subtract": [
            { "$add": [ "$ts", 5.5*1000*60*60 ] },
            new Date(0)
          ]},
          { "$mod": [
            { "$subtract": [
              { "$add": [ "$ts", 5.5*1000*60*60 ] },
              new Date(0)
            ]},
            1000*60*60*24
          ]}
        ]},
        new Date(0)
      ]
    },
    "count": { "$sum": 1 }
  }}
])