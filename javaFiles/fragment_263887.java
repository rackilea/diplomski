Seq.seq(lazyFileStream)              // Seq<String>
   .zipWithIndex()                   // Seq<Tuple2<String, Long>>
   .groupBy(tuple -> tuple.v2 / 500) // Map<Long, List<String>>
   .forEach((index, batch) -> {
       process(batch);
   });