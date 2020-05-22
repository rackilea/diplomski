while (sc.hasNext()) {  
    word = sc.next();       
    if (!word.equals("---")) {
        // do something with each word in the input
        // replace this line with your code (probably more than one line of code)

        inputWords.add(word);
    }

    for(int i = 0; i < inputWords.size() - 1; i++){