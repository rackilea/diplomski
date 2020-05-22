{
  "query": {},
  "aggs": {
    "perSupplier": {
      "terms": {
        "field": "supplier"
      },
      "aggs": {
        "TwoDocs": {
          "top_hits": {
            "size": 2
          }
        }
      }
    }
  }
}