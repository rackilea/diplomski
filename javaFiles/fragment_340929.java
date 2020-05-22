List<String> strings = ...;

String result = String.join(",", strings);

// vs

String result = strings.stream().collect(Collectors.joining(","))