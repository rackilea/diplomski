String input = "A cat sat on a mat and wore a hat A cat sat on a mat and wore a hat";

Set<String> toFilter = Set.of("cat", "mat"); // Java 9's set.of, for brievety.
Set<String> seen = new HashSet<>();

String result = Arrays.stream(input.split(" "))
        .filter(s -> !toFilter.contains(s) || seen.add(s))
        .collect(Collectors.joining(" "));

System.out.println(result); // A cat sat on a mat and wore a hat A sat on a and wore a hat