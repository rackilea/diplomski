String[][] strArray = {{"Sample1", "Sample2"}, {"Sample3", "Sample4", "Sample5"}};

Stream<String> stream = Arrays.stream(strArray)
        .flatMap(indStream -> Arrays.stream(indStream))
        .takeWhile(ele -> !ele.equalsIgnoreCase("Sample4"));

// breakpoint here
System.out.println(stream);