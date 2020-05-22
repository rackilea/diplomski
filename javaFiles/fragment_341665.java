val catalog =
        s"""{
            |"table":{"namespace":"default", "name":"my_table"},
            |"rowkey":"id",
            |"columns":{
            |"id":{"cf":"rowkey", "col":"id", "type":"string"},
            |"name":{"cf":"info", "col":"name", "type":"string"},
            |"age":{"cf":"info", "col":"age", "type":"string"}
            |}
            |}""".stripMargin

    val spark = SparkSession
        .builder()
        .appName("hbase spark")
        .getOrCreate()

    val df = spark
        .read
        .options(
            Map(
                HBaseTableCatalog.tableCatalog -> catalog
            )
        )
        .format("org.apache.spark.sql.execution.datasources.hbase")
        .load()

    df.show()