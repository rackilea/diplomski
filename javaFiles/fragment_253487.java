List<Abc> abcWithDupList = 
abcList.stream()
       .collect(groupingBy(Abc::getRowNum))
       .values()
       .stream()  // Stream<List<Abc>>
       .filter(l-> l.size()>=2)
       .flatMap(List::stream)
       .collect(toList());