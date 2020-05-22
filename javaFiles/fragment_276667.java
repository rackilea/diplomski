public static class myMapper extends Mapper<LongWritable, Text, LongWritable, Text>{
       private Path[] localArchives;
       private Path[] localFiles;

       public void configure(Configuration conf) throws IOException {
         localArchives = DistributedCache.getLocalCacheArchives(conf);
         localFiles = DistributedCache.getLocalCacheFiles(conf);
       }



    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
            //ENVELOPE IS FROM THE JTS.JAR library
        Envelope e1 = new Envelope(-180, 85, 180, -85);
            context.write(key, value);

    }

}