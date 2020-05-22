List<A> aList = ...;

Stream<String> stream = aList.stream()
                             .flatMap(a -> Stream.concat(
                                      a.getsOne().stream(), 
                                      a.getsTwo().stream())
                              );