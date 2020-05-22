List<Integer> myInts = asList(1,2,3,4,5);
List<Long> myLongs = asList(1L, 2L, 3L, 4L, 5L);
List<Double> myDoubles = asList(1.0, 2.0, 3.0, 4.0, 5.0);

System.out.println(sum(myInts)); //compiler error
System.out.println(sum(myLongs)); //compiler error
System.out.println(sum(myDoubles)); //compiler error