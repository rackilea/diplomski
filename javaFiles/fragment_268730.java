String[] array = { "string-a20", "string-a01", "string-b01",
    "string-b20", "string-c01", "string-c20",
    "string-a100", "string-b100", "string-c100" };

Pattern p = Pattern.compile("^.*?-([A-Za-z]+)(\\d+)$");

List<String> result = Arrays.stream(array)
    .map(p::matcher)
    .filter(Matcher::find)
    .sorted(Comparator.comparing((Matcher m) -> m.group(1)) // Compare the letter part
        .thenComparingInt(m -> Integer.parseInt(m.group(2)))) // Compare the number part
    .map(m -> m.group(0)) // Map back to String
    .collect(Collectors.toList());

System.out.println(result);