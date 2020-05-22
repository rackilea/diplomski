Stream<Integer> stream = Stream.of (1,2,3,4,5);
Accumulator result =
    stream.reduce(new Accumulator(0,0), // initial value
                  (acc, i) -> {acc.a += i;acc.b++; return acc;}, // add current value to
                                                                 // the accumulator
                  (acc1, acc2) -> new Accumulator (acc1.a+acc2.a,acc1.b+acc2.b)); // combine two accumulators
System.out.println ("sum = " + result.a);
System.out.println ("count = " + result.b);