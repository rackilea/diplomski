long totalSum = listOfClassB.stream()
     .filter(Objects::nonNull)
     .map(ClassB::getAnotherObjList)
     .filter(Objects::nonNull)
     .mapToInt(List::size)
     .sum();