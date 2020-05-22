db.Product.aggregate([
  {
    $sort: {
      product: 1,
      version: -1,
      createdDate: -1
    }
  },
  {
    $group: {
      _id: "$product",
      root: {
        $push: "$$ROOT"
      }
    }
  },
  {
    $sort: {
      _id: 1
    }
  },
  {
    $replaceRoot: {
      newRoot: {
        $arrayElemAt: [
          {
            $concatArrays: [
              {
                $filter: {
                  input: "$root",
                  cond: {
                    $eq: [
                      "$$this.version.state",
                      "Actif"
                    ]
                  }
                }
              },
              [
                {
                  $arrayElemAt: [
                    "$root",
                    0
                  ]
                }
              ]
            ]
          },
          0
        ]
      }
    }
  }
])