String str = 
"I found a street animal. It was a dog. \nThen the dog found another dog. \nIt was kind of fun to see the two dogs barking to each other."; 

Pattern pattern = Pattern.compile("(?<=dog\\.(?!\\s*\\n))\\s*");
Matcher matcher = pattern.matcher(str);
str = matcher.replaceAll("\r\n");