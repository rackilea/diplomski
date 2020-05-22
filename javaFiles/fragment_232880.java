String input = "The man liked his big hat. The hat was very big";
    int proximity = 5;

    // split input into words
    String[] words = input.split("[\\W]+");

    // create a Deque of the first <proximity> words
    Deque<String> haystack = new LinkedList<String>(Arrays.asList(Arrays.copyOfRange(words, 0, proximity)));

    // count duplicates in the first <proximity> words
    int count = haystack.size() - new HashSet<String>(haystack).size();
    System.out.println("initial matches: " + count);

    // process the rest of the words
    for (int i = proximity; i < words.length; i++) {
        String word = words[i];
        System.out.println("matching '" + word + "' in [" + haystack + "]");

        if (haystack.contains(word)) {
            System.out.println("matched word " + word + " at index " + i);
            count++;
        }

        // remove the first word
        haystack.removeFirst();
        // add the current word
        haystack.addLast(word);
    }

    System.out.println("total matches:" + count);