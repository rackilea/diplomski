"graph": {
  "nodes": [{
    "name": "B",
    "edges": [{
      "label": "1",
      "successor": "B"
    }, {
      "label": "0",
      "successor": {
        "name": "A",
        "edges": [{
          "label": "1",
          "successor": "A"
        }, {
          "label": "0",
          "successor": "B"
        }]
      }
    }]
  }, "A"]
}