public void test() {
      int n = 1000;     
      long start;
      System.out.println("Testing with " + n + " numbers ..."); 

      System.out.println("Test removing elements backwards:");
      List<Integer> numbers1 = Stream.iterate(1, k -> k + 1).limit(n).collect(Collectors.toList());
      start = System.nanoTime();    
      List<Integer> out1 = this.removeBackward(numbers1);
      System.out.println("Time taken:" + (System.nanoTime() - start));
  //    System.out.println(out1);

      System.out.println("Test maintaining extra list for retained elements:");
      List<Integer> numbers2 = Stream.iterate(1, k -> k + 1).limit(n).collect(Collectors.toList());
      start = System.nanoTime();    
      List<Integer> out2 = this.extraRetainedList(numbers2);
      System.out.println("Time taken:" + (System.nanoTime() - start));
  //    System.out.println(out2);

      System.out.println("Test collecting retained elements at end of list:");
      List<Integer> numbers3 = Stream.iterate(1, k -> k + 1).limit(n).collect(Collectors.toList());
      start = System.nanoTime();    
      List<Integer> out3 = this.retainedAtEnd(numbers3);
      System.out.println("Time taken:" + (System.nanoTime() - start));
  //    System.out.println(out3);

      System.out.println("Test maintaining extra list for elements to remove:");
      List<Integer> numbers4 = Stream.iterate(1, k -> k + 1).limit(n).collect(Collectors.toList());
      start = System.nanoTime();    
      List<Integer> out4 = this.extraDeletedList(numbers4);
      System.out.println("Time taken:" + (System.nanoTime() - start));
  //    System.out.println(out4);
    }