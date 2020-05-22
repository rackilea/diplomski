reader = new BufferedReader(new InputStreamReader(new FileInputStream(...), "you have to know it"));
  writer = new OutputStreamWriter(new FileOutputStream(...), "UTF-8"); 
  String line;
  while ((line=reader.readLine())!=null) {
     writer.write(line);
  }