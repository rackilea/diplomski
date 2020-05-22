public class Map extends Mapper<LongWritable,Text,Text,Text>{
private final Text commonKey = new Text("CommonKey");

    @Override
    protected void map( LongWritable key,Text value,Context context) 
                            throws IOException,InterruptedException {
        String line = value.toString().trim();
        String[] kvpair = line.split("\\s+");
        context.write(commonKey, new Text(kvpair[0] + "," + kvpair[1]));
    }
}