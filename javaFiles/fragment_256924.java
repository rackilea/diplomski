String t1 = "test1:testVar('varName', 'ns2:test')";
String t2 = "test2:testVar('varName', 'ns2:test', 'defValue')";
String patternString = "\\('.*?',\\s*('.*?:.*?').*?\\)";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(t1);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}
matcher = pattern.matcher(t2);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}