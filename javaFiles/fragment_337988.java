String [] wordCount = new String[5];

    wordCount[0] = fWord;
    wordCount[1] = sWord;
    wordCount[2] = tWord;
    wordCount[3] = fhWord;
    wordCount[4] = ffWord;

    String longest = "";

    longest = wordCount[0]; //get the first array of words for checking

    for(String s : wordCount) //iterate to all the array of words
    {
        if(longest.length() < s.length()) //check if the last longest word is greater than the current workd
            longest = s; //if the current word is longer then make it the longest word
    }

    System.out.println("Longest Word: " + longest + " lenght: " + longest.length());