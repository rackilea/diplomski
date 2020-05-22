String[] arr = {"ical", "ic", "ion", "ogy"};
String input = "Hello world, this sentence is magic. Because we will talk about Biology.";
String regex = "(" + arr[0];
for (String s: arr)
   regex += "|" + s; // using Pattern.quote(s) instead of s here would be safer
regex += ")\\b";
input = input.replaceAll(regex, "");
System.out.println(input);