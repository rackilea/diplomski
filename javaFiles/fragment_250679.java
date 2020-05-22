JavaRDD<MyObject> cRDD = spark.read().textFile("C:/Temp/File0.csv").javaRDD()
                       .map(new Function<String, MyObject>() {
                              @Override
                              public MyObject call(String line) throws Exception {
                                     String[] parts = line.split(" ");
                                     MyObject c = new MyObject();
                                     c.setX(parts[0].trim());
                                     c.setY(parts[1].trim());                                   
                                     c.setLabel(0);
                                     return c;
                              }
                       });


          Dataset<Row> mainDataset = spark.createDataFrame(cRDD, MyObject.class);