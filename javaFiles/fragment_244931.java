// Add all words (other than "---") into inputWords
while (sc.hasNext()) {  
    word = sc.next();       
    if (!word.equals("---")) {
        inputWords.add(word);
    }
}

// Now iterate over inputWords and process each word one-by-one
for (int i = 0; i < inputWords.size(); i++) {