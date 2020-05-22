private YourXMLParser xmlParser = null;
    @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            super.setup(context);
            xmlParser= new YourXMLParser();        
        }

     @Override
        protected void cleanup(Mapper<ImmutableBytesWritable, Result, NullWritable, Put>.Context context) throws IOException,
                        InterruptedException {
            super.cleanup(context);
                  xmlParser= null;
    }