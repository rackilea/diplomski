// Extract words
String[] words = theString.split(" ");

// Manipulate them
for (int i = 0; i < words.length; i++) {
    words[i] = "+" + words[i];
}

// Put them back as sentence
StringJoiner sj = new StringJoiner(" ");
for (String word : words) {
    sj.add(word);
}

String sentence = sj.toString();