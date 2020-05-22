for (Integer integer : arrayList) { 
           IntStream.range(0, linkedList.size()) 
                 .filter(j -> linkedList.get(j) > integer) 
                 .findFirst() 
                 .ifPresent(j -> linkedList.add(j, integer)); 
}