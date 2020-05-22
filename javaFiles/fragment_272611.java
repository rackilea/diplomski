String BOUNDARY_STR = "[a-zA-Z]+(?:'[a-zA-Z]+)?";
String test = "Hello i'm @£$@you @@can !!be.";
Matcher matcher = Pattern.compile(BOUNDARY_STR).matcher(test);
List<String> results = new ArrayList<>();
while (matcher.find()){
    results.add(matcher.group(0));
} 
System.out.println(results); // => [Hello, i'm, you, can, be]