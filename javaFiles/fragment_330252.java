Random rand = new Random(); // generate Random object only once for efficiency purposes

// ... rest of your code

String getLicenceKey(String key1, String key2){
    List<String> tokens = new ArrayList<String>();

    // add tokens from key1
    for(int i = 0; i < key1.length(); i += 2) {
        tokens.add(key1.substring(i, i + 2));
    }

    // add tokens from key2
    for(int i = 0; i < key2.length(); i += 2) {
        tokens.add(key2.substring(i, i + 2));
    }

    // build the random result out of the tokens
    StringBuilder result = new StringBuilder();
    while(tokens.size() != 0){
        int randomPos = rand.nextInt(tokens.size());
        result.append(tokens.remove(randomPos));
    }

    return result.toString();
}