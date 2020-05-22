List<Document> pipeline = Arrays.<Document>asList(
  new Document(
    "$match", new Document(
      "shipdate", new Document(
        "$lte", 19980801             
      )
    )
  ),
  new Document(
    "$group", new Document(
      "_id", new Document(
        "returnflag", "$returnflag"
      ).append( "linestatus", "$linestatus" )
    ).append(
      "count", new Document( "$sum", 1 )
    ).append(
      "sum_qty", new Document( "$sum", "$quantity" )
    ).append(
      "avg_qty", new Document( "$avg", "$quantity" )
    ).append(
      "sum_base_price", new Document( "$sum", "$extendedprice" )
    ).append(
      "avg_base_price", new Document( "$avg", "$extendedprice" )
    ).append(
      "sum_disc_price", new Document(
        "$sum", new Document(
          "$multiply", Arrays.asList(
            "$extendedprice",
            new Document(
              "$subtract", Arrays.asList(1, "$discount")
            )
          )
        )
      )
    ).append(
      "avg_disc_price", new Document(
        "$avg", new Document(
          "$multiply", Arrays.asList(
            "$extendedprice",
            new Document(
              "$subtract", Arrays.asList(1, "$discount")
            )
          )
        )
      )
    ).append(
      "sum_charge", new Document(
        "$sum", new Document(
          "$multiply", Arrays.asList(
            "$extendedprice",
            new Document(
              "$subtract", Arrays.asList(1, "$discount")
            ),
            new Document(
              "$add", Arrays.asList(1, "$tax")
            )
          )
        )
      )
    ).append(
      "avg_disc", new Document( "$avg", "$discount" )
    )
  )
);

AggregateIterable<Document> result = collection.aggregate(pipeline);