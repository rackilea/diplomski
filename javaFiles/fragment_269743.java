public static void writeFinalData() throws Exception{
   BufferedWriter bw = new BufferedWriter(new FileWriter(new File("words.txt")));

   for(String s : finalData){
      bw.write(s);
      bw.newLine();
   }

   bw.close();
}