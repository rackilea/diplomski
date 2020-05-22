String input = "...";
String regex = "(DmetaD\\(.*?\\)|DConD\\(.*?\\))";
List<String> result = Pattern.compile(regex)
        .matcher(input)
        .results()
        .map(MatchResult::group)
        .collect(Collectors.toList());