else if (action.equals(clear)) {

   // Need to close this first to avoid resource leak
   pw.close(); 

   File data = new File("StoredInfo.txt");

   // I believe you will need pw later
   pw = new PrintWriter(new FileWriter(data, false));

}