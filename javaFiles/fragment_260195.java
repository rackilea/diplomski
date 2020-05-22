import org.apache.spark.api.java.function.Function;

...

SparkConf conf = new SparkConf().setAppName("PCA Example");
SparkContext sc = new SparkContext(conf);

JavaRDD<String> data = sc.textFile("clean-sl-mix-with-labels.txt",0).toJavaRDD();
JavaRDD<double[]> whatYouWantRdd = data.map(new Function<String, double[]>() {
    @Override
    public double[] call(String row) throws Exception {
        return splitStringtoDoubles(row);
    }

    private double[] splitStringtoDoubles(String s) {
        String[] splitVals = s.split("\\t");
        Double[] vals = new Double[splitVals.length];
        for(int i=0; i < splitVals.length; i++) {
            vals[i] = Double.parseDouble(splitVals[i]);
        }
        return vals;
    }
});

List<double[]> whatYouWant = whatYouWantRdd.collect();