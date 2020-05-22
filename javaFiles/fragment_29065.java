LongAdder longAdder = new LongAdder();

 for (int i=0; i< 1000000000; i++)
    longAdder.increment();

 System.out.println(longAdder.sum());