public static void main(String args[]){
  try{
   FileInputStream fstream = new FileInputStream("textfile.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      while ((strLine = br.readLine()) != null)   {
  String[] tokens = str.split(" ");
  Record record = new    Record(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);//process  record , etc

 }
 in.close();
  }catch (Exception e){
    System.err.println("Error: " + e.getMessage());
 }
  }
  }