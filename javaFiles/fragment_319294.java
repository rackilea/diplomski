String str = "--Hello& World-@ 1234...  my email is me@example.com";

// Analyzing every word     
String[] words = str.split("\\s+");
String regex = "^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$";
String result = "";

for (String word : words) {
    result += word.replaceAll(regex, "") + " ";             
}

System.out.println(result); // gives "Hello World 1234 my email is me@example.com "