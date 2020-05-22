Path pt=new Path("hdfs://pathTofile");
FileSystem fs = FileSystem.get(context.getConfiguration());
BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
try {
  String line;
  line=br.readLine();
  while (line != null){
    System.out.println(line);

    // be sure to read the next line otherwise you'll get an infinite loop
    line = br.readLine();
  }
} finally {
  // you should close out the BufferedReader
  br.close();
}