Files.lines(dictionaryPath)
        .skip(5) // skip first five lines
        .map(line -> line.split(";")) // split by ';'
        .filter(dictData -> data.equals(dictData[2])) // filter by second element
        .findFirst() // get first that matches and, if present, print it
        .ifPresent(dictData -> System.out.println("Your Data Item is: " + dictData[0]));