String string = "I want this split up into pairs";
String[] words = string.split(" ");
List<String> pairs = new ArrayList<String>();
for (int i = 0; i < words.length-1; ++i) {
    pairs.add(words[i] + " " + words[i+1]);
}
System.out.println(pairs);