public static void main(String[] args) {
   ArrayList<Integer> inputList =  new ArrayList<Integer>();
   ArrayList<Integer> outputList =  new ArrayList<Integer>();
   inputList.add(36);inputList.add(36);inputList.add(36);inputList.add(36);
   inputList.add(37);inputList.add(37);inputList.add(38);
   Set<Integer>hashSet = new TreeSet<Integer>();
   for(Integer val:inputList){
       hashSet.add(val);
   }
   for(Integer i:hashSet){
       outputList.add(i);
   }
}