Matcher matcher = ...

StringBuffer buffer = new StringBuffer();
while (matcher.find()){
    String matchedPart = ...
    ...
    matcher.appendReplacement(buffer, replacement); 
}
matcher.appendTail(buffer);
String result = buffer.toString();