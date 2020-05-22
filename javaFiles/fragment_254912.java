String text = "12 + (ab-bc*3)";
List<String> results = Pattern.compile("\\p{Punct}|\\w+").matcher(text)
    .results()
    .map(MatchResult::group)
    .collect(Collectors.toList());
System.out.println(results); 
// => "12", "+", "(", "ab", "-", "bc", "*", "3", ")"