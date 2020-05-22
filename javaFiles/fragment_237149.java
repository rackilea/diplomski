public String[] request(String requesturl, String user, String password){

   //init List
   List<String> values = new ArrayList<String>(); 

   //add values to List like this
   values.add("myString");


   //return a array with the correct size at last
   return  values.toArray(new String[values.size()]);

}