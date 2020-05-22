String separator = ",";
JavaRDD<String> ys = rdd
        .map(new Function<List<String>, String>() {
            @Override
            public String call(List<String> xs) throws Exception {
                return String.join(separator, xs);
            }
        });