try {
   String currentLine;

   reader = new BufferedReader(new FileReader("QuizScores.txt"));
   while ((currentLine = reader.readLine()) != null) {

       int sum = 0;
       String[] nums = currentLine.split("\\s+");
       for (int i = 0; i < nums.length; i++) {
           try{
               int num = Integer.parseInt(nums[i]);
               if (num != -1) {
                   sum += num;
               }
           } catch( NumberFormatException nfe )
           {
              // maybe log it?
           }
       }

       System.out.println(sum / nums.length);
   }
} catch (IOException err) {
    err.printStackTrace();
} 
// catch (NumberFormatException err) {}
finally {
    try {
       if (reader != null){
           reader.close();
    } catch (IOException err) {
        err.printStackTrace();
    }
}