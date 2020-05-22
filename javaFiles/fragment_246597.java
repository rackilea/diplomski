public Set<Intege> StringSetToIntegerSet(Set<String> input) throws Exception{
   Set<Integer> output=new HashSet<Integer>();
   for(String s : input){
      output.add(Integer.parseInt(s));
   }
   return output;
}