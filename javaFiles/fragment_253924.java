String string = Files.readString(Paths.get(PATH_TO_FILE));  // get file content
String[] arr = string.split(" ");

List<String> pairs = IntStream.iterate(0, n -> n < arr.length, n -> n + 2)
        .mapToObj(i -> arr[i] + "-" + arr[i + 1])
        .collect(Collectors.toList());

System.out.println(pairs);    // [0-12, 85-45, 20-14, 255-145]