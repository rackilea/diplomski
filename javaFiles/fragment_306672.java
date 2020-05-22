int[] myArray = {3,5,1,-7,6,34,88,2,-8,9,10,4,33};
Map<Integer,List<Integer>> version1 = new HashMap<>();
for(int i = 2; i< 100; i++){
    for(int x : myArray){
        if(x%i==0)
           version1.computeIfAbsent(i, k -> new ArrayList<>()).add(x);
    }            
}
System.out.println(version1);