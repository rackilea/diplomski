String generateFileName(K k, V v) {
   return k.toString() + "_" + v.toString();
 }

 public class MOReduce extends
   Reducer<WritableComparable, Writable,WritableComparable, Writable> {
 private MultipleOutputs mos;
 public void setup(Context context) {
 ...
 mos = new MultipleOutputs(context);
 }

 public void reduce(WritableComparable key, Iterator<Writable> values,
 Context context)
 throws IOException {
 ...
 mos.write("text", , key, new Text("Hello"));
 mos.write("seq", LongWritable(1), new Text("Bye"), "seq_a");
 mos.write("seq", LongWritable(2), key, new Text("Chau"), "seq_b");
 mos.write(key, new Text("value"), generateFileName(key, new Text("value")));
 ...
 }

 public void cleanup(Context) throws IOException {
 mos.close();
 ...
 }

 }