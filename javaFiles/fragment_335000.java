import static com.jayway.jsonpath.matchers.JsonPathMatchers.*;

// query for specific path 
String jsonSpecificPathQuery = "$..name.fname.displayName";

String content = new String(Files.readAllBytes(Paths.get("C://temp/xx.json")));
Object parsedContent = Configuration.defaultConfiguration().jsonProvider().parse(content);
System.out.println("hasJsonPath? " + hasJsonPath(jsonSpecificPathQuery).matches(parsedContent));