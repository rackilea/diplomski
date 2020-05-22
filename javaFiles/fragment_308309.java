JavaPairRDD<String, PortableDataStream> imageByteRDD = jsc.binaryFiles(SOURCE_PATH);
    if(!imageByteRDD.isEmpty())
        imageByteRDD.foreachPartition(new VoidFunction<Iterator<Tuple2<String,PortableDataStream>>>() {

            @Override
            public void call(
                    Iterator<Tuple2<String, PortableDataStream>> arg0)
                    throws Exception {
                Configuration conf = new Configuration();
                conf.set("fs.defaultFS", HDFS_PATH);
                while(arg0.hasNext()){
                    Tuple2<String,PortableDataStream>fileTuple = arg0.next();
                    Text key = new Text(fileTuple._1());
                    String fileName = key.toString().split(SEP_PATH)[key.toString().split(SEP_PATH).length-1].split(DOT_REGEX)[0];
                    String fileExtension = fileName.split(DOT_REGEX)[fileName.split(DOT_REGEX).length-1];

                      BytesWritable value = new BytesWritable( fileTuple._2().toArray());
                         SequenceFile.Writer writer = SequenceFile.createWriter(
                                 conf, 
                                 SequenceFile.Writer.file(new Path(DEST_PATH + fileName + SEP_KEY + getCurrentTimeStamp()+DOT+fileExtension)),
                               SequenceFile.Writer.compression(SequenceFile.CompressionType.RECORD, new BZip2Codec()),
                               SequenceFile.Writer.keyClass(Text.class), SequenceFile.Writer.valueClass(BytesWritable.class));
                         key = new Text(key.toString().split(SEP_PATH)[key.toString().split(SEP_PATH).length-2] + SEP_KEY + fileName + SEP_KEY + fileExtension);
                            writer.append(key, value);
                         IOUtils.closeStream(writer);

                }
            }
        });