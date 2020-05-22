JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

    JavaRDD<Integer> rddList
          = jsc.parallelize(
                    IntStream.range(0, coresCount * 2)
                             .boxed().collect(Collectors.toList()))
               .repartition(coresCount);