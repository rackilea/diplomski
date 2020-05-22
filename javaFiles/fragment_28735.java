@Override
protected void setup(Context context)
      throws IOException, InterruptedException {
    context.write(new Text("<MapReduce>"), null);
  }


public static class Mapreducers extends
        Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values,
            Context context) throws IOException, InterruptedException {
int maxValue = Integer.MIN_VALUE;
for (IntWritable value : values) {
     maxValue = Math.max(maxValue, value.get());
}
Text out = new Text(constructPropertyXml(key, maxValue));
context.write(out, null);
  }

}
public static String constructPropertyXml(Text key, Text maxvalue) {
    StringBuilder sb = new StringBuilder();
    sb.append("<result><key>").append(key)
        .append("</key><value>").append(maxvalue)
        .append("</value></result>");
    return sb.toString();
  }
@Override
  protected void cleanup(Context context)
      throws IOException, InterruptedException {
    context.write(new Text("</MapReduce>"), null);
  }