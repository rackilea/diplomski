public class SparkExcel {
    public static void main(String[] args) {
        //spark session
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkExcel")
                .master("local[*]")
                .getOrCreate();

        //Read
        Dataset<Row> df = spark
                .read()
                .format("org.zuinnote.spark.office.excel")
                .option("read.locale.bcp47", "de")
                .load("c:\\temp\\test1.xlsx");

        //Print
        df.show();
        df.printSchema();

        //Flatmap function
        FlatMapFunction<Row, String[]> flatMapFunc = new FlatMapFunction<Row, String[]>() {
            @Override
            public Iterator<String[]> call(Row row) throws Exception {
                ArrayList<String[]> rowList = new ArrayList<String[]>();
                List<Row> spreadSheetRows = row.getList(0);
                for (Row srow : spreadSheetRows) {
                    ArrayList<String> arr = new ArrayList<String>();
                    arr.add(srow.getString(0));
                    arr.add(srow.getString(1));
                    arr.add(srow.getString(2));
                    arr.add(srow.getString(3));
                    arr.add(srow.getString(4));
                    rowList.add(arr.toArray(new String[] {}));
                }
                return rowList.iterator();
            }
        };

        //Apply flatMap function
        Dataset<String[]> df2 = df.flatMap(flatMapFunc, spark.implicits().newStringArrayEncoder());

        //Write
        df2.write()
           .mode(SaveMode.Overwrite)
           .format("org.zuinnote.spark.office.excel")
           .option("write.locale.bcp47", "de")
           .save("c:\\temp\\test2.xlsx");

    }
}