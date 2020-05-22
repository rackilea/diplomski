public void map(WritableComparable key, Writable val, Context context)
        throws IOException, InterruptedException {
    try{
        Configuration config = context.getConfiguration();
        String[] strs = val.toString().split(Constants.HIVE_RECORD_COLUMN_SEPARATOR);
        String family = config.get(Constants.CUBEBUILDER_CONFIGURATION_FAMILY);
        String column = strs[COLUMN_INDEX];
        String Value = strs[VALUE_INDEX];
        String sKey = generateKey(strs, config);
        byte[] bKey = Bytes.toBytes(sKey);
        Put put = new Put(bKey);
        put.add(Bytes.toBytes(family), Bytes.toBytes(column), (value <= 0) 
                        ? Bytes.toBytes(Double.MIN_VALUE)
                        : Bytes.toBytes(value));

        ImmutableBytesWritable ibKey = new ImmutableBytesWritable(bKey);
        context.write(ibKey, put);

        context.getCounter(CubeBuilderContextCounters.CompletedMapExecutions).increment(1);
    }
    catch(Exception e){
        context.getCounter(CubeBuilderContextCounters.FailedMapExecutions).increment(1);    
    }

}