List<Integer> numbers = new ArrayList<Integer>();
for(i=1;i<=498/2;i++){
   int z=498%i;
   if(z==o){
     numbers.add(i);
   }
}

int [] myNumbers = numbers.toArray(new Integer[numbers.size()]);