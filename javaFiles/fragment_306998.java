String searchString = "this ( is \\ a $ %A%.";
String extractorToken = "(.+?)";

int indexOfWildcard = searchString.indexOf("%A%");
String pattern = Pattern.quote(searchString.substring(0, indexOfWildcard)) +
                 extractorToken +
                 Pattern.quote(searchString.substring(indexOfWildcard + 3, searchString.length()));
Matcher matcher = Pattern.compile(pattern).matcher(inputString);