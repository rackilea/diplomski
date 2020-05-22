public class EmailReducer extends Reducer<Text, Text, NullWritable, Text> {

  private static final ObjectMapper mapper = new ObjectMapper();

  public void reduce(Text key, Iterable<Text> values, Context context)
        throws IOException, InterruptedException {

    Map<String, Object> result = new HashMap<>(); 
    result.put("address", key.toString());
    result.put("to", 0);
    result.put("from", 0);

    for (Text value : values) {
        switch (value.toString()) {
        case "TO":
            result.put("to", ((int) result.get("to")) + 1);
            break;
        case "FROM":
            result.put("from", ((int) result.get("from")) + 1);
            break;
    }

    context.write(NullWritable.get(),  new Text(mapper.writeValueAsString(result)));

  }
}