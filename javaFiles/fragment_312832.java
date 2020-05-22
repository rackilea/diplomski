List<A> list = ...;
List<Long> uniqueIds = list.stream()                 //Stream<A>
                           .map(A::getBs)            //Stream<List<B>>
                           .flatMap(List::stream)    //Stream<B>
                           .map(B::getIds)           //Stream<List<Long>>
                           .flatMap(List::stream)    //Stream<Long>
                           .distinct()
                           .collect(toList());