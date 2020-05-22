@Override
  public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

  if(value.toString().startWith("Code,Description")){
      // Skip header line (first line) of CSV
       return;
  }

  String data[] = value.toString().split(",", -1);

  String code= data[0];
  String codeType = data[2];

....
....
and so one