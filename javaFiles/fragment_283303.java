Configuration conf = new Configuration();
    conf.set("mongo.job.input.format", "com.mongodb.hadoop.MongoInputFormat");
    conf.set("mongo.input.uri", "mongodb://localhost:27017/databasename.collectionname");
    SparkConf sconf = new SparkConf().setMaster("local").setAppName("Spark UM Jar");

    JavaRDD<User> UserMaster = sc.newAPIHadoopRDD(conf, MongoInputFormat.class, Object.class, BSONObject.class)
            .map(new Function<Tuple2<Object, BSONObject>, User>() {
                @Override
                public User call(Tuple2<Object, BSONObject> v1) throws Exception {
                    //return User
                }

            }