yourList.stream()
        .collect(Collectors.groupingBy(
               A::getName,
               Collectors.collectingAndThen(
                      Collectors.maxBy(Comparator.comparing(A::getCreatedDate)), 
                      Optional::get)))
        .values();