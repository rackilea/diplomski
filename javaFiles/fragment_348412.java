// collect frequencies
    Map<String, Long> collect = "abbccdde".chars()
            .mapToObj(c -> Character.toString((char) c))
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

    // find max
    long max = collect.values().stream().max(Comparator.naturalOrder()).get();

    //filter values for max
    String result = collect.entrySet()
            .stream()
            .filter(x -> x.getValue() == max)
            .map(Map.Entry::getKey)
            .collect(Collectors.joining(","));

    String output = "The most frequent letter are " + result +  " with: " + max + "occurrences";

    System.out.println("output = " + output);