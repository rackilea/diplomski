public JavaRDD<Row> readFolder(String filePath) {
    JavaSparkContext javaSparkContext = new JavaSparkContext(sparkContext);
    JavaPairRDD<String, String> fileNameContentsRDD = javaSparkContext.wholeTextFiles(filePath, 1);

    JavaRDD<Row> rowRDD = fileNameContentsRDD.flatMap((FlatMapFunction<Tuple2<String, String>, Row>) fileNameContent -> {
        String fileName = fileNameContent._1();
        String content = fileNameContent._2();
        String[] lines = content.split("[\r\n]+");
        List<Row> array = new ArrayList<Row>(lines.length);
        for(String line : lines){
            String[] sp = line.split(" ");
            array.add(RowFactory.create(fileName, sp[1], sp[3], sp[2]));
        }
        return array.iterator();
    });

    return rowRDD;
}