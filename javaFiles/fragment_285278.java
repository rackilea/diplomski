String str2 = Stream
    .of(str.split(","))
    .map(Integer::parseInt)
    .sorted()
    .map(String::valueOf)
    .collect(joining(","));