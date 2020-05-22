Map<String,Record> result = 
    list.stream()
        .sorted(Comparator.comparing(Record::score))
        .collect(Collectors.groupingBy(Record::name, 
                                       LinkedHashMap::new,
                                       Collectors.maxBy(Comparator.comparing(Record::getScore))));