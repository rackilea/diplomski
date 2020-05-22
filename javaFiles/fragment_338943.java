@Override
 public void map(Object key, Text value,
   Context context) throws IOException, InterruptedException {

    String[] fields = value.toString().split("\\t", -1); 
    for (int i = 0; i < fields.length; ++i) {
        if ("".equals(fields[i])) fields[i] = null;
    }
    if (fields[4] != null) {
    System.out.println(fields[0]);
    System.out.println(fields[4]);
    context.write(new Text(fields[0]),new Text(fields[4]));
    }
    }
}