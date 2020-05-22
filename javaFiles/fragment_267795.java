JavaRDD<String> exposuresRdd = ctx.textFile(fname);

StringBuilder sb = null;
JavaRDD<String> transformedrdd= exposuresRdd.flatMap(new Function<String,String>() {

    @Override
    public String call(String line) throws Exception {
sb = new StringBuilder(); 
sb.append(Something);
return sb.toString();

 });
}