Set<String> unique = new HashSet<>();
for (String word : Case.words) {
    // Adds only if the same uppercase String wasn't added before
    unique.add(word.toUpperCase());  
}
return (float) unique.size() / Case.words.size(); // convert one of the ints to float