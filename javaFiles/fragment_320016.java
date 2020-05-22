coGroupedRDD
   .flatMap(t -> {
        List<Row> result = new ArrayList<>();
        //...use t._1, t._2._1, t._2._2 to construct the result list
        return result.iterator();
    });