public static List<Integer> filter(List<Integer> input) {
   List<Integer> rtn = new ArrayList<Integer>();
   for( Integer i : input) {
      if(i != 1) rtn.push(i);
   }
   return rtn;
}