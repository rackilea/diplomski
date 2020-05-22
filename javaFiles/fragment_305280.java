public class TopKRecord extends Configured implements Tool {

    public static class MapClass extends Mapper<LongWritable, Text, Text, Text> {

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            // your map code goes here
            String[] fields = value.toString().split(",");
            String year = fields[1];
            String claims = fields[8];

            if (claims.length() > 0 && (!claims.startsWith("\""))) {
                context.write(new Text(year.toString()), new Text(claims.toString()));
            }
        }
    }

    ...
}