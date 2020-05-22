Stream<Foo> stream = stream1.collect(concat(stream2)).collect(concat(element));

Stream<Foo> stream = stream1
                     .filter(x -> x!=0)
                     .collect(concat(stream2))
                     .filter(x -> x!=1)
                     .collect(concat(element))
                     .filter(x -> x!=2);