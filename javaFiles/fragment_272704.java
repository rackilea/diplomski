val rdd = spark.sparkContext.parallelize(Seq((1, Iterable(1,2,3,4,5)), (2, Iterable(6,7,8)), (3, Iterable(1,3,6,8,4,2,7,8,3))))

val maxLength = 3
val res = rdd.flatMap{ case(id, vals) =>
  vals.grouped(maxLength).map(v => (id, v))
}