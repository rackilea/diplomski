Predicate<String> hasEvenLength = (String word) -> word.length() % 2 == 0;

Map<Boolean,Set<String>> partition =
    Files.lines(Paths.get(fileName))                       // get the lines
         .flatMap(Pattern.compile("\\W+")::splitAsStream)  // split the lines into words
         .collect(Collectors.partitioningBy(hasEvenLength, // parition by even length
             Collectors.mapping(String::toUpperCase,       // uppercase
                 Collectors.toCollection(TreeSet::new)))); // put into sorted set

Set<String> evenWords = partition.get(Boolean.TRUE);
Set<String> oddWords = partition.get(Boolean.FALSE);