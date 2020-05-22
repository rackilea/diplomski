db.collectionName.aggregate({
"$unwind": "$attributes" // first unwind attributes array 
}, {
"$match": {
  "attributes.tag": {
    "$in": ["media", "stream"] // put all matching tags in array using $in
  }
}
}, {
"$group": {
  "_id": "$_id",
  "name": {
    "$first": "$name"
  },
  "attributes": {
    "$push": "$attributes" // push all attributes to get only matching tags
  }
}
}).pretty()