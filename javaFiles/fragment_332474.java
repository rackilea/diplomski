BufferedReader br = new BufferedReader(new FileReader("file.txt"));
try {
    String val=br.readLine();
    String [] splitted=val.split(" ");
}
finally {
   br.close();
}