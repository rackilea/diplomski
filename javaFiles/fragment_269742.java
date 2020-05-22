public static void processData(){
   //looping through every line in the .csv file, spliting it by , and saving every     piece of the data into a new array list
   for(String d : readData){
      String[] split = d.split(",");
      for(int i = 0; i < split.length; i++){
         splitData.add(split[i]);
      }
   }

//searching the .csv file for keywords
for(String s : splitData){
   for(String k : readTerms){
      //testing if the data from the .csv file contains (or is equal to) the keyword. If true then we add it to the array list which holds the final data that will be writen back to the file
      if(s.contains(k)){
         finalData.add(s);
      }
   }
}
}