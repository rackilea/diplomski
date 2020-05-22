Stream<Foo> stream = concat(stream1, concat(stream2, element));

Stream<Foo> stream = concat(
                         concat(stream1.filter(x -> x!=0), stream2).filter(x -> x!=1),
                         element)
                     .filter(x -> x!=2);