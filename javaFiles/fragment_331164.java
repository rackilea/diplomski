function ReadFile () {
  var file = new java.io.BufferedReader(new java.io.FileReader("file"));
  var fileWriter = new java.io.FileWriter("file2",false);
  while ((line = file.readLine()) != null) {
    if (line.contains ("/"))
      line = line.replace("/","\\");

    fileWriter.write(line + "\n");
 }
 fileWriter.close();
 file.close();
}
ReadFile ();