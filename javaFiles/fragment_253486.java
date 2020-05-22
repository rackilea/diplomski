List<Abc> abcList = ...;

Map<Integer,List<Abc>> elementsByRowNum =
abcList.stream()
       .collect(groupingBy(Abc::getRowNum));

List<Abc> abcWithDupList = 
elementsByRowNum.values().stream()
               .filter(v-> v.size()>=2)
               .flatMap(List::stream)
               .collect(toList());