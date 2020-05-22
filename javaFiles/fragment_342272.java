// read file into list
    List<String> linesInFile = Files.readAllLines(Paths.get("filename.txt"));
    // create 2d array based on number of lines
    List<List<String>> array = new ArrayList<>(linesInFile.size());

    // iterate through every line of the file and split the elements using whitespace
    linesInFile.forEach(line -> {
        // get the elements in the current line
        String[] elements = line.split("\\s+");
        // store it in our 2d array
        array.add(Arrays.asList(elements));
    });

    // print every row in our 2d array
    array.forEach(System.out::println);