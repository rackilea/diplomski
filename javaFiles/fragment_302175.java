List<String> output =
    Collections.nCopies(3,text) // List<List<String>> with 3 copies of 
                                // original List
               .stream() // Stream<List<String>>
               .flatMap(List::stream) // Stream<String>
               .collect(Collectors.toList()); // List<String>