Pattern pattern = Pattern.compile("(href=\"javascript:openWin.*)(Images.*\")");
try (Stream<String> lines = Files.lines(Paths.get("input.txt"))) {
    String result = lines
            .map(pattern::matcher)
            .map(matcher -> matcher.replaceAll("$1http://google.com/$2"))
            .collect(Collectors.joining("\n"));
    System.out.println(result);
}