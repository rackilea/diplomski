for (ArrayList<String> ar1 : l) {
   if(line.size() != 9) {      
     System.out.println("This line only had "+line.size()+" elements - supposed to contain 9");
     for(String item : ar1) {
        //Show for finding the error
        System.out.println("- " + item);
     }
   } else {
      for(int i = 0; i <9; ++i) {
        ps.setString(i+1, ar1.get(i));
      }
      //Mark this line to be added
      ps.addBatch();
   }     
}
int[] result = ps.executeBatch();