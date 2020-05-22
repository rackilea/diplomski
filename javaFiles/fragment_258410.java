@Override
public void run(Mapper<LongWritable, Text, Text, Text>.Context context)
        throws IOException, InterruptedException {

   if(Predicate.runMapper(context)) {
      super.run(context); // do the usual setup/map/cleanup cycle
   }
}