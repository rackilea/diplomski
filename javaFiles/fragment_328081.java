// if the word is already present in the hashmap
    if (my_collection.containsKey(word)) {
        // just increment the current frequency of the word
        // this overrides the existing frequency
        my_collection.put(word, my_collection.get(word) + 1);
    } else {
        // since the word is not there just put it with a frequency 1
        my_collection.put(word, 1);
    }