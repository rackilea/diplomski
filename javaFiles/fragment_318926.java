String fileName = "MSFT.csv";
File file = new File(fileName);
try{
   Scanner inputStream = new Scanner(file);
   while(inputStream.hasNextLine()){
      String data = inputStream.nextLine();
      System.out.println(data);
   }
   inputStream.close();
}  catch(FileNotFoundException e){
   e.printStackTrace();