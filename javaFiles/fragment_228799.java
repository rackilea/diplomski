m.value1= Arrays.asList(11,12);
m1.value2 = Arrays.asList(1,2,3,4,5); 

for(Integer i : m.value1) {
   for(Integer j : m1.value2){
      System.out.println("("+i+","+j+")");
   }
}