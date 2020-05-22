public class MyWritable extends Writable{
  private String _1;
  private String[] _2;

  public MyWritable(Tuple2<String, String[]> data){
    _1 = data._1;
    _2 = data._2;
  }

  public Tuple2<String, String[]> get(){
    return new Tuple2(_1, _2);
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    _1 = WritableUtils.readString(in);
    ArrayWritable _2Writable = new ArrayWritable();
    _2Writable.readFields(in);
    _2 = _2Writable.toStrings();
  }

  @Override
  public void write(DataOutput out) throws IOException {
    Text.writeString(out, _1);
    ArrayWritable _2Writable = new ArrayWritable(_2);
    _2Writable.write(out);
  }
}