{
  "query": {
    "nested": {
      "path": "hobbies",
      "query": {
        "match": {
          "hobbies.description": "Gardening"
        }
      }
    }
  }
}