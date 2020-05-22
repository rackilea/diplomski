interface FilterNumber {
    public boolean test(Integer i);
}

class Filter1s implements FilterNumber {
    public Filter1s(){};
    public boolean test(Integer i) { return i != 1; }
} 


public static List<Integer> filter(List<Integer> input, FilterNumber filterNumber) {
   List<Integer> rtn = new ArrayList<Integer>();
   for( Integer i : input) {
      if(filterNumber.test(i)) rtn.push(i);
   }
   return rtn;
} 

filter(list, new Filter1s());